package com.example.bookstory.ui.main.fragment.category.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstory.R;
import com.example.bookstory.ui.base.BaseFragment;
import com.example.bookstory.vo.BookType;

import java.util.List;

import javax.inject.Inject;


public class BookTypeFragment extends BaseFragment {

    @Inject
    ViewModelProvider.Factory factory;

    private BookTypeViewModel viewModel;
    private BookTypeAdapter bookTypeAdapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity(), factory).get(BookTypeViewModel.class);
        return inflater.inflate(R.layout.fragment_book_type, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerview(view);
        viewModel.getBookTypeLocal().observe(getViewLifecycleOwner(), bookTypes -> {
            setAdapter(bookTypes, getView());
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel.getBookTypeNetwork()
                .observe(requireActivity(),
                        bookTypes -> {
                            setAdapter(bookTypes, getView());
                            if (viewModel.getBookTypeLocal().hasObservers()) {
                                viewModel.getBookTypeLocal().removeObservers(getViewLifecycleOwner());
                                viewModel.onAsyncLocal(bookTypes);
                            }
                        });

    }


    private void initRecyclerview(View view) {
        bookTypeAdapter = new BookTypeAdapter();
        recyclerView = view.findViewById(R.id.rv_bookType);
        recyclerView.setAdapter(bookTypeAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
    }

    private void setAdapter(List<BookType> list, View view) {
        bookTypeAdapter.setList(list);
        bookTypeAdapter.setItemOnClick(bt -> {
            Bundle bundle = new Bundle();
            bundle.putParcelable("BookType", bt);
            Navigation.findNavController(view).navigate(R.id.action_categoryFragment_to_categoryBookFragment, bundle);
        });
    }

    @Override
    protected String setTitle() {
        return "Category";
    }
}
