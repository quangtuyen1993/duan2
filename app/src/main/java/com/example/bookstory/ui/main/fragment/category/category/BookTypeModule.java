package com.example.bookstory.ui.main.fragment.category.category;

import androidx.lifecycle.ViewModel;

import com.example.bookstory.di.annnotations.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class BookTypeModule {
    @Binds
    @IntoMap
    @ViewModelKey(BookTypeViewModel.class)
    public abstract ViewModel bindBookTypeViewModel(BookTypeViewModel viewModel);
}
