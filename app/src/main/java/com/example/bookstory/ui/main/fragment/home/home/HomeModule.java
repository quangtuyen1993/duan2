package com.example.bookstory.ui.main.fragment.home.home;

import androidx.lifecycle.ViewModel;

import com.example.bookstory.di.annnotations.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class HomeModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    abstract public ViewModel bindHomeViewModel(HomeViewModel viewModel);
}
