package com.example.bookstory.ui.main.fragment.home.title;

import androidx.lifecycle.ViewModel;

import com.example.bookstory.di.annnotations.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class BookTitleModule {
    @Binds
    @IntoMap
    @ViewModelKey(BookTitleViewModel.class)
    abstract public ViewModel bindBookTitleViewModel(BookTitleViewModel viewModel);
}
