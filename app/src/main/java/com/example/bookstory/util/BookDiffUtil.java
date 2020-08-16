package com.example.bookstory.util;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.example.bookstory.vo.Book;

import java.util.List;

public class BookDiffUtil extends DiffUtil.Callback {
    private List<Book> oldList;
    private List<Book> newList;

    public BookDiffUtil(List<Book> oldList, List<Book> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();

    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        if (oldList.isEmpty()) return true;
        return newList.get(newItemPosition).getId().equals(oldList.get(oldItemPosition).getId());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        if (oldList.isEmpty()) return true;
        return oldList.get(oldItemPosition) == newList.get(newItemPosition);
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
