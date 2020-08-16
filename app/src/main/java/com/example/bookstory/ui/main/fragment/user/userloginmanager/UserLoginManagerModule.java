package com.example.bookstory.ui.main.fragment.user.userloginmanager;

import androidx.lifecycle.ViewModel;

import com.example.bookstory.di.annnotations.FragmentScope;
import com.example.bookstory.di.annnotations.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class UserLoginManagerModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserLoginManagerViewModel.class)
    public abstract ViewModel bindUserManagerViewModel(UserLoginManagerViewModel vm);
}
