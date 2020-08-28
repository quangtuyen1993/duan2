package com.example.bookstory.ui.research;

import com.example.bookstory.di.annnotations.ViewModelKey;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.MapKey;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public  abstract class SearchModule {
    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel.class)
    abstract ViewModel bindSearchViewModel(SearchViewModel searchViewModel);
}
