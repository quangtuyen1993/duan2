package com.example.bookstory.ui.main.fragment.home.readBook;

import androidx.lifecycle.ViewModel;

import com.example.bookstory.di.annnotations.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module()
public abstract class ReadBookModule {
    @Binds
    @IntoMap
    @ViewModelKey(ReadBookViewModel.class)
    abstract public ViewModel bindHomeViewModel(ReadBookViewModel viewModel);
}
