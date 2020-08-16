package com.example.bookstory.ui.main.fragment.library;

import androidx.lifecycle.ViewModel;

import com.example.bookstory.di.annnotations.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class HistoryModule {
    @Binds
    @IntoMap
    @ViewModelKey(HistoryViewModel.class)
    public abstract ViewModel bindHistoryViewModel(HistoryViewModel historyViewModel);
}
