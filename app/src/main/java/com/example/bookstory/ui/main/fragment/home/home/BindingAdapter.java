package com.example.bookstory.ui.main.fragment.home.home;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstory.util.BookAdapter;
import com.example.bookstory.vo.Book;

import java.util.List;

public abstract class BindingAdapter {


    @androidx.databinding.BindingAdapter("android:SetAdapter")
    public static void bindRecyclerView(RecyclerView view, List<Book> books) {
        view.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false));
        BookAdapter adapter = new BookAdapter();
        view.setAdapter(adapter);

    }
}
