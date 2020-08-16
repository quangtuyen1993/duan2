package com.example.bookstory.ui.main.fragment.home.readBook.viewpager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bookstory.vo.Chapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ReadBookAdapter extends FragmentStateAdapter {

    @Override
    public void registerFragmentTransactionCallback(@NonNull FragmentTransactionCallback callback) {
        super.registerFragmentTransactionCallback(callback);
    }

    private List<Chapter> chapters = new ArrayList<>();

    public ReadBookAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    public ReadBookAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NotNull
    @Override
    public Fragment createFragment(int position) {
        Chapter chapter = chapters.get(position);
        Fragment fragment = new ReadBookViewPager();
        Bundle args = new Bundle();
        args.putString("ChapterId", chapter.getId());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }
}
