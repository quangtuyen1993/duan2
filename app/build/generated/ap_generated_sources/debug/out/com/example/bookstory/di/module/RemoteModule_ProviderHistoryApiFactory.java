// Generated by Dagger (https://dagger.dev).
package com.example.bookstory.di.module;

import com.example.bookstory.service.HistoryApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RemoteModule_ProviderHistoryApiFactory implements Factory<HistoryApi> {
  private final RemoteModule module;

  private final Provider<Retrofit> retrofitProvider;

  public RemoteModule_ProviderHistoryApiFactory(RemoteModule module,
      Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public HistoryApi get() {
    return providerHistoryApi(module, retrofitProvider.get());
  }

  public static RemoteModule_ProviderHistoryApiFactory create(RemoteModule module,
      Provider<Retrofit> retrofitProvider) {
    return new RemoteModule_ProviderHistoryApiFactory(module, retrofitProvider);
  }

  public static HistoryApi providerHistoryApi(RemoteModule instance, Retrofit retrofit) {
    return Preconditions.checkNotNull(instance.providerHistoryApi(retrofit), "Cannot return null from a non-@Nullable @Provides method");
  }
}
