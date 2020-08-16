package com.example.bookstory.util;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstory.databinding.ItemBookBinding;
import com.example.bookstory.vo.Book;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private List<Book> books = new ArrayList<>();
    public ItemOnClick<Book> itemOnClick;

    public void setBooks(List<Book> books) {
        Log.e("Adapter",books.size()+"");
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new BookDiffUtil(this.books, books));
        diffResult.dispatchUpdatesTo(this);
        this.books.clear();
        this.books.addAll(books);
        notifyDataSetChanged();
    }

    public void setItemOnClick(ItemOnClick<Book> itemOnClick) {
        this.itemOnClick = itemOnClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemBookBinding binding = ItemBookBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = books.get(position);
        holder.bind(book);
        holder.itemView.setOnClickListener(v -> {
            if (itemOnClick != null) {
                itemOnClick.onClick(book);
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemBookBinding binding;

        ViewHolder(@NonNull ItemBookBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Book book) {
            binding.setBook(book);
            binding.executePendingBindings();
        }
    }
}
