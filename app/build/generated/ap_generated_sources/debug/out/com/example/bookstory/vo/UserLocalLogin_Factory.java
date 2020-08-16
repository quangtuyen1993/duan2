// Generated by Dagger (https://dagger.dev).
package com.example.bookstory.vo;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UserLocalLogin_Factory implements Factory<UserLocalLogin> {
  private final Provider<Application> contextProvider;

  public UserLocalLogin_Factory(Provider<Application> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public UserLocalLogin get() {
    return newInstance(contextProvider.get());
  }

  public static UserLocalLogin_Factory create(Provider<Application> contextProvider) {
    return new UserLocalLogin_Factory(contextProvider);
  }

  public static UserLocalLogin newInstance(Application context) {
    return new UserLocalLogin(context);
  }
}
