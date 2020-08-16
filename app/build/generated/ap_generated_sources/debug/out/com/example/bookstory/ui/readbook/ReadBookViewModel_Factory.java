// Generated by Dagger (https://dagger.dev).
package com.example.bookstory.ui.readbook;

import com.example.bookstory.data.response.ChapterRepository;
import com.example.bookstory.vo.UserLocalLogin;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ReadBookViewModel_Factory implements Factory<ReadBookViewModel> {
  private final Provider<ChapterRepository> chapterRepositoryProvider;

  private final Provider<UserLocalLogin> userLocalLoginProvider;

  public ReadBookViewModel_Factory(Provider<ChapterRepository> chapterRepositoryProvider,
      Provider<UserLocalLogin> userLocalLoginProvider) {
    this.chapterRepositoryProvider = chapterRepositoryProvider;
    this.userLocalLoginProvider = userLocalLoginProvider;
  }

  @Override
  public ReadBookViewModel get() {
    return newInstance(chapterRepositoryProvider.get(), userLocalLoginProvider.get());
  }

  public static ReadBookViewModel_Factory create(
      Provider<ChapterRepository> chapterRepositoryProvider,
      Provider<UserLocalLogin> userLocalLoginProvider) {
    return new ReadBookViewModel_Factory(chapterRepositoryProvider, userLocalLoginProvider);
  }

  public static ReadBookViewModel newInstance(ChapterRepository chapterRepository,
      UserLocalLogin userLocalLogin) {
    return new ReadBookViewModel(chapterRepository, userLocalLogin);
  }
}
