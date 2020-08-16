package com.example.bookstory.util.pagination;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstory.databinding.ItemBookBinding;
import com.example.bookstory.util.ItemOnClick;
import com.example.bookstory.vo.Book;

public class PageListAdapterCustom extends PagedListAdapter<Book, PageListAdapterCustom.BookItemViewHolder> {
    private ItemOnClick<Book> itemOnClick;

    public void setItemOnClick(ItemOnClick<Book> itemOnClick) {
        this.itemOnClick = itemOnClick;
    }

    public PageListAdapterCustom() {
        super(Book.DIFF_BOOK);
    }

    @NonNull
    @Override
    public BookItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBookBinding binding = ItemBookBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new BookItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookItemViewHolder holder, int position) {
        holder.bind(getItem(position));
        holder.binding.getRoot().setOnClickListener(v -> itemOnClick.onClick(getItem(position)));
    }

    static class BookItemViewHolder extends RecyclerView.ViewHolder {
        ItemBookBinding binding;

        public BookItemViewHolder(@NonNull ItemBookBinding itemBookBinding) {
            super(itemBookBinding.getRoot());
            this.binding = itemBookBinding;
        }

        public void bind(Book book) {
            binding.setBook(book);
            binding.executePendingBindings();
        }
    }
}
