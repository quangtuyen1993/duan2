package com.example.bookstory.ui.booktitle;

import androidx.lifecycle.ViewModel;

import com.example.bookstory.di.annnotations.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class BookTitleModel {
    @Binds
    @IntoMap
    @ViewModelKey(BookTitleViewModel.class)
    public abstract ViewModel bindBookTitle(BookTitleViewModel bookTitleViewModel);

}
