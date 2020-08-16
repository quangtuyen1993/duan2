package com.example.bookstory.di.component;

import android.app.Application;

import com.example.bookstory.BookStoryApp;
import com.example.bookstory.di.module.ActivityBuilder;
import com.example.bookstory.di.module.AppModule;
import com.example.bookstory.di.module.DBModule;
import com.example.bookstory.di.module.FactoryModule;
import com.example.bookstory.di.module.NetWorkModule;
import com.example.bookstory.di.module.RemoteModule;
import com.example.bookstory.di.module.UserModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        RemoteModule.class,
        DBModule.class,
        ActivityBuilder.class,
        FactoryModule.class,
        UserModule.class,
        NetWorkModule.class})
@Singleton
public interface AppComponent extends AndroidInjector<BookStoryApp> {
    void inject(Application application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder builder(Application application);
        AppComponent build();
    }
}
