package com.example.bookstory.ui.main.fragment.category.categorybook;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstory.R;
import com.example.bookstory.ui.base.BaseFragment;
import com.example.bookstory.ui.booktitle.BookTitleActivity;
import com.example.bookstory.util.BookAdapter;
import com.example.bookstory.util.pagination.PageListAdapterCustom;
import com.example.bookstory.vo.Book;
import com.example.bookstory.vo.BookType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;


public class BookTypeBookFragment extends BaseFragment {
    private BookType bookType;
    private RecyclerView recyclerView;
    private BookTypeBookViewModel viewModel;
    private BookAdapter bookAdapter;
    PageListAdapterCustom listAdapterCustom;

    @Inject
    ViewModelProvider.Factory factory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bookType = getArguments().getParcelable("BookType");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_book_type_book, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this, factory).get(BookTypeBookViewModel.class);
        initRecyclerView(view);
        viewModel.keyWord.setValue(bookType.getId());
        viewModel.getBooksLocal().observe(getViewLifecycleOwner(), books -> {
            List<Book> filter = books.stream().filter(b -> b.getBookType().stream()
                    .anyMatch(bt -> bt.getName().equals(bookType.getName())))
                    .collect(Collectors.toList());
            recyclerView.setAdapter(bookAdapter);
            bookAdapter.setBooks(filter);
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel.getBooksNetwork().observe(getViewLifecycleOwner(), books -> {
                    if (viewModel.getBooksLocal().hasObservers()) {
                        viewModel.getBooksLocal().removeObservers(getViewLifecycleOwner());
                    }
                    bookAdapter.setBooks(books);
//                    recyclerView.setAdapter(listAdapterCustom);
//                    listAdapterCustom.submitList(books);
                }
        );
    }

    private void initRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.rv_book);
        listAdapterCustom = new PageListAdapterCustom();
        bookAdapter = new BookAdapter();
        bookAdapter.setItemOnClick(this::itemAdapterClick);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
    }

    private void itemAdapterClick(Book book) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("book", book);
        Intent intent = new Intent(getActivity(), BookTitleActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected String setTitle() {
        return "BookCategory";
    }
}
