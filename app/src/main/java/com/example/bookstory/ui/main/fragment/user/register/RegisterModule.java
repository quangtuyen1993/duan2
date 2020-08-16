package com.example.bookstory.ui.main.fragment.user.register;

import androidx.lifecycle.ViewModel;

import com.example.bookstory.di.annnotations.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class RegisterModule {
    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel.class)
    abstract ViewModel bindRegisterViewModel(RegisterViewModel vm);
}
