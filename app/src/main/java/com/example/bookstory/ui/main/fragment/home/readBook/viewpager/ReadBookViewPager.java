package com.example.bookstory.ui.main.fragment.home.readBook.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.bookstory.R;
import com.example.bookstory.ui.base.BaseFragment;

import javax.inject.Inject;


public class ReadBookViewPager extends BaseFragment {

    @Inject
    ViewModelProvider.Factory factory;
    private ReadBookPagerViewModel viewModel;

    private String idChapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity(), factory).get(ReadBookPagerViewModel.class);
        return inflater.inflate(R.layout.fragment_read_book_view_pager, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        assert getArguments() != null;
        idChapter = getArguments().getString("ChapterId");

        TextView tv_content = view.findViewById(R.id.tv_content);
        TextView tv_title = view.findViewById(R.id.tv_title);
        viewModel.chapter.observe(getViewLifecycleOwner(), chapter -> {
            tv_content.setText(chapter.getContent());
            tv_title.setText(chapter.getName());
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.idChapter.postValue(idChapter);
    }

    @Override
    protected String setTitle() {
        return "Read Book";
    }
}
