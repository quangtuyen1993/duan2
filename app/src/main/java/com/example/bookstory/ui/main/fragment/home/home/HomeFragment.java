package com.example.bookstory.ui.main.fragment.home.home;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstory.R;
import com.example.bookstory.dao.BookDAO;
import com.example.bookstory.databinding.FragmentHomeBinding;
import com.example.bookstory.ui.base.BaseFragment;
import com.example.bookstory.ui.booktitle.BookTitleActivity;
import com.example.bookstory.util.BookAdapter;
import com.example.bookstory.vo.Book;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    @Inject
    ViewModelProvider.Factory factory;
    @Inject
    BookDAO bookDAO;
    private Toolbar toolbar;
    private FragmentHomeBinding binding;
    private BookAdapter bookAdapter;

    private SearchView searchView;
    private HomeViewModel vm;
    private LinearLayoutManager layoutManager;
    private LinearLayoutManager layoutManager2;
    CarouselView carouselView;

    private int pastVisiblesItems, visibleItemCount, totalItemCount;
    int index = 1;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater);
        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vm = new ViewModelProvider(this, factory).get(HomeViewModel.class);
        carouselView = view.findViewById(R.id.carouselView);
        carouselView.setPageCount(3);
        initToolbar(view);
        binding.setLifecycleOwner(this);
        binding.setHomeViewModel(vm);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.executePendingBindings();
        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                vm.loadLocal().observe(getViewLifecycleOwner(),books ->{
                    Picasso.get().load(books.get(position).getImgUrl())
                            .into(imageView);
                });
            }
        };
        carouselView.setImageListener(imageListener);

        bookAdapter = new BookAdapter();
        layoutManager = new LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false);
        binding.rv.setLayoutManager(layoutManager);
        bookAdapter.setItemOnClick(this::setItemOnClick);
        binding.rv.setAdapter(bookAdapter);
        binding.rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                onScrolledListener(recyclerView, dx, dy);
            }
        });
        vm.loadLocal().observe(getViewLifecycleOwner(), books ->
                bookAdapter.setBooks(books)
        );
        layoutManager2 = new LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false);

        binding.rvTopViews.setLayoutManager(layoutManager2);
        binding.rvTopViews.setAdapter(bookAdapter);
        binding.rvTopViews.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                onScrolledListener(recyclerView, dx, dy);
            }
        });
    }

    private void initToolbar(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm.result.observe(getViewLifecycleOwner(), books -> {
            if (vm.loadLocal().hasObservers()) {
                vm.loadLocal().removeObservers(getViewLifecycleOwner());
            }
            if (vm.page.getValue() != null && vm.limit.getValue() != null) {
                vm.insertNewListDao(books);
//                binding.tvLoad.setText("(" + vm.page.getValue() + "/" + ((int) Math.ceil(vm.limit.getValue())) + ")");
                bookAdapter.setBooks(books);
            }
        });
        vm.isLoading.observe(getViewLifecycleOwner(), isLoad -> {
            if (isLoad) {
//                binding.progress.setVisibility(View.VISIBLE);
            } else {
//                binding.progress.setVisibility(View.GONE);
            }
        });
    }

    private void onScrolledListener(RecyclerView recyclerView, int dx, int dy) {
        if (dy > 0) {
            visibleItemCount = layoutManager.getChildCount();
            totalItemCount = layoutManager.getItemCount();
            pastVisiblesItems = layoutManager.findFirstVisibleItemPosition();
            if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                vm.onTestLoadMore();
            }
        }
    }

    private void setItemOnClick(Book book) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("book", book);
        Intent intent = new Intent(getActivity(), BookTitleActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }



    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        requireActivity().getMenuInflater().inflate(R.menu.menu_appbar, menu);
        MenuItem searchViewItem = menu.findItem(R.id.menu_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        SearchView.SearchAutoComplete searchAutoComplete
                = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        searchAutoComplete.setHintTextColor(getResources().getColor(android.R.color.background_dark));
        searchAutoComplete.setTextColor(getResources().getColor(android.R.color.background_dark));
        ImageView searchIcon = searchView.findViewById(androidx.appcompat.R.id.search_button);
        searchIcon.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_baseline_search_24));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                vm.onSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        searchView.setOnCloseListener(() -> {
            vm.onSearch("");
            return false;
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_refresh) {
            bookAdapter.setBooks(new ArrayList<>());
            vm.refresh();
            vm.keyWord.setValue("");
//            vm.loadMoreNormal();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected String setTitle() {
        return "Home";
    }
}
