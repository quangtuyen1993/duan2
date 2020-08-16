package com.example.bookstory.ui.readbooklocal;

import androidx.lifecycle.ViewModel;

import com.example.bookstory.di.annnotations.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ReadBookLocalModule {
    @Binds
    @IntoMap
    @ViewModelKey(ReadBookLocalViewModel.class)
    abstract ViewModel bindReadBookViewModel(ReadBookLocalViewModel viewModel);
}
