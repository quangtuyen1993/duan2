package com.example.bookstory.di.module;

import com.example.bookstory.BookStoryApp;

import dagger.Module;


@Module
public class AppModule {
    BookStoryApp bookStoryApp;
    public AppModule(BookStoryApp bookStoryApp) {
        this.bookStoryApp = bookStoryApp;
    }
}
