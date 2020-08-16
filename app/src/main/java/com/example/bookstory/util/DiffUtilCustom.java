package com.example.bookstory.util;

import androidx.recyclerview.widget.DiffUtil;

import com.example.bookstory.vo.BaseVo;
import com.example.bookstory.vo.Book;

import java.util.List;

public class DiffUtilCustom extends DiffUtil.Callback {
    List<Book> oldList;
    List<Book> newList;

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
        return oldList.get(oldItemPosition).getId().equals(newList.get(newItemPosition).getId());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }
}
