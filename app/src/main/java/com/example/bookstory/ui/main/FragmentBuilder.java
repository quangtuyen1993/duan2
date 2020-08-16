package com.example.bookstory.ui.main;

import com.example.bookstory.di.annnotations.FragmentScope;
import com.example.bookstory.ui.main.fragment.category.category.BookTypeFragment;
import com.example.bookstory.ui.main.fragment.category.category.BookTypeModule;
import com.example.bookstory.ui.main.fragment.category.categorybook.BookTypeBookFragment;
import com.example.bookstory.ui.main.fragment.category.categorybook.BookTypeBookModule;
import com.example.bookstory.ui.main.fragment.home.home.HomeFragment;
import com.example.bookstory.ui.main.fragment.home.home.HomeModule;
import com.example.bookstory.ui.main.fragment.home.readBook.ReadBookFragment;
import com.example.bookstory.ui.main.fragment.home.readBook.ReadBookModule;
import com.example.bookstory.ui.main.fragment.home.readBook.viewpager.ReadBookPagerModule;
import com.example.bookstory.ui.main.fragment.home.readBook.viewpager.ReadBookViewPager;
import com.example.bookstory.ui.main.fragment.home.title.BookTitleFragment;
import com.example.bookstory.ui.main.fragment.home.title.BookTitleModule;
import com.example.bookstory.ui.main.fragment.library.HistoryLibraryFragment;
import com.example.bookstory.ui.main.fragment.library.HistoryModule;
import com.example.bookstory.ui.main.fragment.user.login.LoginFragment;
import com.example.bookstory.ui.main.fragment.user.login.LoginModule;
import com.example.bookstory.ui.main.fragment.user.register.RegisterFragment;
import com.example.bookstory.ui.main.fragment.user.register.RegisterModule;
import com.example.bookstory.ui.main.fragment.user.userloginmanager.UserLoginManagerFragment;
import com.example.bookstory.ui.main.fragment.user.userloginmanager.UserLoginManagerModule;
import com.example.bookstory.ui.main.fragment.user.usermanager.UserManagerFragment;
import com.example.bookstory.ui.main.fragment.user.usermanager.UserManagerModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilder {
    @FragmentScope
    @ContributesAndroidInjector(modules = {HomeModule.class})
    public abstract HomeFragment bindHomeFragment();


    @FragmentScope
    @ContributesAndroidInjector(modules = {BookTitleModule.class})
    public abstract BookTitleFragment bindBookTitleFragment();


    @FragmentScope
    @ContributesAndroidInjector(modules = {ReadBookModule.class})
    public abstract ReadBookFragment bindReadBookFragment();


    @FragmentScope
    @ContributesAndroidInjector(modules = {ReadBookPagerModule.class})
    public abstract ReadBookViewPager bindReadBookViewPager();


    @FragmentScope
    @ContributesAndroidInjector(modules = {BookTypeModule.class})
    public abstract BookTypeFragment bindBookTypeFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {BookTypeBookModule.class})
    public abstract BookTypeBookFragment bindBookTypeBookFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {LoginModule.class})
    public abstract LoginFragment bindLoginFragment();


    @FragmentScope
    @ContributesAndroidInjector(modules = {UserLoginManagerModule.class})
    public abstract UserLoginManagerFragment bindUserManagerFragment();


    @FragmentScope
    @ContributesAndroidInjector(modules = {UserManagerModule.class})
    public abstract UserManagerFragment bindUserMangerFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {RegisterModule.class})
    public abstract RegisterFragment bindRegisterFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {HistoryModule.class})
    public abstract HistoryLibraryFragment bindHistoryFragment();
}
