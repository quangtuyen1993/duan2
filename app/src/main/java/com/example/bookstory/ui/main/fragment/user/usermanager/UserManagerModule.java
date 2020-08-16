package com.example.bookstory.ui.main.fragment.user.usermanager;

import androidx.lifecycle.ViewModel;

import com.example.bookstory.di.annnotations.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class UserManagerModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserManagerViewModel.class)
    public abstract ViewModel provideUserMangerViewModel(UserManagerViewModel viewModel);
}
