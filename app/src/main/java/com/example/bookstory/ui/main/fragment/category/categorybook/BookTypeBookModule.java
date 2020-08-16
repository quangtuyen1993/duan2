package com.example.bookstory.ui.main.fragment.category.categorybook;

import androidx.lifecycle.ViewModel;

import com.example.bookstory.di.annnotations.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class BookTypeBookModule {
    @Binds
    @IntoMap
    @ViewModelKey(BookTypeBookViewModel.class)
    public abstract ViewModel bindBookTypeBookViewModel(BookTypeBookViewModel viewModel);
}
