package com.example.bookstory.ui.readbook;

import androidx.lifecycle.ViewModel;

import com.example.bookstory.di.annnotations.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ReadBookModule {
    @Binds
    @IntoMap
    @ViewModelKey(ReadBookViewModel.class)
    public abstract ViewModel bindReadBookViewModel(ReadBookViewModel readBookViewModel);
}
