// Generated by Dagger (https://dagger.dev).
package com.example.bookstory.ui.main.fragment.user.usermanager;

import com.example.bookstory.data.response.UserRepository;
import com.example.bookstory.vo.UserLocalLogin;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UserManagerViewModel_Factory implements Factory<UserManagerViewModel> {
  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<UserLocalLogin> userLocalLoginProvider;

  public UserManagerViewModel_Factory(Provider<UserRepository> userRepositoryProvider,
      Provider<UserLocalLogin> userLocalLoginProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
    this.userLocalLoginProvider = userLocalLoginProvider;
  }

  @Override
  public UserManagerViewModel get() {
    UserManagerViewModel instance = newInstance(userRepositoryProvider.get());
    UserManagerViewModel_MembersInjector.injectUserLocalLogin(instance, userLocalLoginProvider.get());
    return instance;
  }

  public static UserManagerViewModel_Factory create(Provider<UserRepository> userRepositoryProvider,
      Provider<UserLocalLogin> userLocalLoginProvider) {
    return new UserManagerViewModel_Factory(userRepositoryProvider, userLocalLoginProvider);
  }

  public static UserManagerViewModel newInstance(UserRepository userRepository) {
    return new UserManagerViewModel(userRepository);
  }
}
