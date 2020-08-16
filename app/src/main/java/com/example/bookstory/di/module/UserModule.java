package com.example.bookstory.di.module;

import android.app.Application;

import com.example.bookstory.vo.UserLocalLogin;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @Singleton
    @Provides
    public UserLocalLogin userLocalLogin(Application context) {
        return new UserLocalLogin(context);
    }
}
