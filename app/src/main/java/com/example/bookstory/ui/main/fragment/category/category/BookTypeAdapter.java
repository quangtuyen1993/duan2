package com.example.bookstory.ui.main.fragment.category.category;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstory.databinding.ItemBookTypeBinding;
import com.example.bookstory.util.ItemOnClick;
import com.example.bookstory.vo.BookType;

import java.util.ArrayList;
import java.util.List;

public class BookTypeAdapter extends RecyclerView.Adapter<BookTypeAdapter.ViewHolder> {

    private List<BookType> list = new ArrayList<>();
    private ItemOnClick<BookType> itemOnClick;

    public void setItemOnClick(ItemOnClick<BookType> itemOnClick) {
        this.itemOnClick = itemOnClick;
    }

    public void setList(List<BookType> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemBookTypeBinding binding = ItemBookTypeBinding.inflate(layoutInflater);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BookType bookType = list.get(position);
        holder.bind(bookType);
        holder.itemBookTypeBinding.getRoot().setOnClickListener(v -> {
            itemOnClick.onClick(bookType);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemBookTypeBinding itemBookTypeBinding;

        ViewHolder(@NonNull ItemBookTypeBinding binding) {
            super(binding.getRoot());
            this.itemBookTypeBinding = binding;
        }

        void bind(BookType bookType) {
            itemBookTypeBinding.setBookType(bookType);
            itemBookTypeBinding.executePendingBindings();
        }
    }
}
