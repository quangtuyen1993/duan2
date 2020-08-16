package com.example.bookstory.ui.main.fragment.home.readBook.viewpager;

import androidx.lifecycle.ViewModel;

import com.example.bookstory.di.annnotations.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ReadBookPagerModule {
    @Binds
    @IntoMap
    @ViewModelKey(ReadBookPagerViewModel.class)
    abstract public ViewModel bindHomeViewModel(ReadBookPagerViewModel viewModel);
}
