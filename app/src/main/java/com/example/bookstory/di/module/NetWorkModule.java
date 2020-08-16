package com.example.bookstory.di.module;

import com.example.bookstory.service.BuildRetrofit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class NetWorkModule {
    @Singleton
    @Provides
    public Retrofit providerRetrofit() {
        return BuildRetrofit.getInstance();
    }
}
