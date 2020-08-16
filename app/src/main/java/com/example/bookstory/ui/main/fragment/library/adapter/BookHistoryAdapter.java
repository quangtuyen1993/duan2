package com.example.bookstory.ui.main.fragment.library.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstory.databinding.ItemBookHistoryBinding;
import com.example.bookstory.util.ItemOnClick;
import com.example.bookstory.vo.History;

import java.util.ArrayList;
import java.util.List;

public class BookHistoryAdapter extends RecyclerView.Adapter<BookHistoryAdapter.ViewHolder> {
    private List<History> list = new ArrayList<>();
    private ItemOnClick<History> itemOnClick;

    public void setItemOnClick(ItemOnClick<History> itemOnClick) {
        this.itemOnClick = itemOnClick;
    }

    public void setList(List<History> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemBookHistoryBinding binding = ItemBookHistoryBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        History history = list.get(position);
        holder.bind(history);
        holder.itemView.setOnClickListener(v->{
            itemOnClick.onClick(history);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ItemBookHistoryBinding binding;

        ViewHolder(@NonNull ItemBookHistoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(History history) {
            binding.setHistory(history);
            binding.executePendingBindings();
        }
    }
}
