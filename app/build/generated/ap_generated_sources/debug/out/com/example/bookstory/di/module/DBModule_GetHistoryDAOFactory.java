// Generated by Dagger (https://dagger.dev).
package com.example.bookstory.di.module;

import com.example.bookstory.dao.DBLocal;
import com.example.bookstory.dao.HistoryDAO;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DBModule_GetHistoryDAOFactory implements Factory<HistoryDAO> {
  private final DBModule module;

  private final Provider<DBLocal> dbLocalProvider;

  public DBModule_GetHistoryDAOFactory(DBModule module, Provider<DBLocal> dbLocalProvider) {
    this.module = module;
    this.dbLocalProvider = dbLocalProvider;
  }

  @Override
  public HistoryDAO get() {
    return getHistoryDAO(module, dbLocalProvider.get());
  }

  public static DBModule_GetHistoryDAOFactory create(DBModule module,
      Provider<DBLocal> dbLocalProvider) {
    return new DBModule_GetHistoryDAOFactory(module, dbLocalProvider);
  }

  public static HistoryDAO getHistoryDAO(DBModule instance, DBLocal dbLocal) {
    return Preconditions.checkNotNull(instance.getHistoryDAO(dbLocal), "Cannot return null from a non-@Nullable @Provides method");
  }
}