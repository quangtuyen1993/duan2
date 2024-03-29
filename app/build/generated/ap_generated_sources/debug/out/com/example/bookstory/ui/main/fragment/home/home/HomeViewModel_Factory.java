// Generated by Dagger (https://dagger.dev).
package com.example.bookstory.ui.main.fragment.home.home;

import com.example.bookstory.dao.BookDAO;
import com.example.bookstory.data.response.BookRepository;
import com.example.bookstory.data.response.FeedRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<BookRepository> bookRepositoryProvider;

  private final Provider<BookDAO> bookDAOProvider;

  private final Provider<FeedRepository> feedRepositoryProvider;

  public HomeViewModel_Factory(Provider<BookRepository> bookRepositoryProvider,
      Provider<BookDAO> bookDAOProvider, Provider<FeedRepository> feedRepositoryProvider) {
    this.bookRepositoryProvider = bookRepositoryProvider;
    this.bookDAOProvider = bookDAOProvider;
    this.feedRepositoryProvider = feedRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(bookRepositoryProvider.get(), bookDAOProvider.get(), feedRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<BookRepository> bookRepositoryProvider,
      Provider<BookDAO> bookDAOProvider, Provider<FeedRepository> feedRepositoryProvider) {
    return new HomeViewModel_Factory(bookRepositoryProvider, bookDAOProvider, feedRepositoryProvider);
  }

  public static HomeViewModel newInstance(BookRepository bookRepository, BookDAO bookDAO,
      FeedRepository feedRepository) {
    return new HomeViewModel(bookRepository, bookDAO, feedRepository);
  }
}
