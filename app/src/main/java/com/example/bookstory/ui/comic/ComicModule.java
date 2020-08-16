package com.example.bookstory.ui.comic;

import androidx.lifecycle.ViewModel;

import com.example.bookstory.di.annnotations.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ComicModule {
    @Binds
    @IntoMap
    @ViewModelKey(ComicViewModel.class)
    abstract ViewModel bindComicViewModel(ComicViewModel viewModel);
}
