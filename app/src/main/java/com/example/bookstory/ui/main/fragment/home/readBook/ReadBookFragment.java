package com.example.bookstory.ui.main.fragment.home.readBook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bookstory.R;
import com.example.bookstory.ui.base.BaseFragment;
import com.example.bookstory.ui.main.fragment.home.readBook.viewpager.ReadBookAdapter;
import com.example.bookstory.util.PagerTransformCustom;
import com.example.bookstory.vo.Book;

import javax.inject.Inject;


public class ReadBookFragment extends BaseFragment {
    @Inject
    ViewModelProvider.Factory factory;
    private ReadBookViewModel viewModel;
    private Book book;
    private ViewPager2 viewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        book = getArguments().getParcelable("book");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity(), factory).get(ReadBookViewModel.class);
        return inflater.inflate(R.layout.fragment_read_book, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.viewPager);
        ReadBookAdapter readBookAdapter = new ReadBookAdapter(this);
        viewPager.setAdapter(readBookAdapter);
        viewPager.setPageTransformer(new PagerTransformCustom());
        viewModel.idBook.postValue(book.getId());
        viewModel.chapters.observe(getViewLifecycleOwner(), readBookAdapter::setChapters);
    }

    @Override
    protected String setTitle() {
        return "Read Book";
    }
}
