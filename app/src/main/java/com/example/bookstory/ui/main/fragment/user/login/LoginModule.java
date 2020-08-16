package com.example.bookstory.ui.main.fragment.user.login;

import androidx.lifecycle.ViewModel;

import com.example.bookstory.di.annnotations.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class LoginModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    public abstract ViewModel bindLoginViewModel(LoginViewModel viewModel);
}
