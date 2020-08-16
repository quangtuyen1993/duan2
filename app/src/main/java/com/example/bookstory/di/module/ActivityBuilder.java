package com.example.bookstory.di.module;

import com.example.bookstory.ui.booktitle.BookTitleActivity;
import com.example.bookstory.ui.booktitle.BookTitleModel;
import com.example.bookstory.ui.comic.ComicActivity;
import com.example.bookstory.ui.comic.ComicModule;
import com.example.bookstory.ui.main.FragmentBuilder;
import com.example.bookstory.ui.main.MainActivity;
import com.example.bookstory.di.annnotations.ActivityScope;
import com.example.bookstory.ui.readbook.ReadBookActivity;
import com.example.bookstory.ui.readbook.ReadBookModule;
import com.example.bookstory.ui.readbooklocal.ReadBookLocalActivity;
import com.example.bookstory.ui.readbooklocal.ReadBookLocalModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = {FragmentBuilder.class})
    abstract MainActivity contributesAndroidInjection();

    @ActivityScope
    @ContributesAndroidInjector(modules = {BookTitleModel.class})
    abstract BookTitleActivity contributesAndroidBookTitleActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = {ReadBookModule.class})
    abstract ReadBookActivity contributesReadBookActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = {ComicModule.class})
    abstract ComicActivity contributesComicActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = {ReadBookLocalModule.class})
    abstract ReadBookLocalActivity contributesReadBookLocalActivity();
}
