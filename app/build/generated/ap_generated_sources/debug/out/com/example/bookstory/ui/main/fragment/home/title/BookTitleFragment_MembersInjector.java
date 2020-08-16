// Generated by Dagger (https://dagger.dev).
package com.example.bookstory.ui.main.fragment.home.title;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class BookTitleFragment_MembersInjector implements MembersInjector<BookTitleFragment> {
  private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

  private final Provider<ViewModelProvider.Factory> factoryProvider;

  public BookTitleFragment_MembersInjector(
      Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider,
      Provider<ViewModelProvider.Factory> factoryProvider) {
    this.androidInjectorProvider = androidInjectorProvider;
    this.factoryProvider = factoryProvider;
  }

  public static MembersInjector<BookTitleFragment> create(
      Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider,
      Provider<ViewModelProvider.Factory> factoryProvider) {
    return new BookTitleFragment_MembersInjector(androidInjectorProvider, factoryProvider);}

  @Override
  public void injectMembers(BookTitleFragment instance) {
    DaggerFragment_MembersInjector.injectAndroidInjector(instance, androidInjectorProvider.get());
    injectFactory(instance, factoryProvider.get());
  }

  @InjectedFieldSignature("com.example.bookstory.ui.main.fragment.home.title.BookTitleFragment.factory")
  public static void injectFactory(BookTitleFragment instance, ViewModelProvider.Factory factory) {
    instance.factory = factory;
  }
}
