package com.example.bookstory.di.module;

import androidx.lifecycle.ViewModelProvider;

import com.example.bookstory.di.vmFactory.ViewModelFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class FactoryModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);
}
