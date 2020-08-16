package com.example.bookstory.di.module;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bookstory.dao.BookDAO;
import com.example.bookstory.dao.BookTypeDAO;
import com.example.bookstory.dao.ChapterDAO;
import com.example.bookstory.dao.ContentComicDAO;
import com.example.bookstory.dao.DBLocal;
import com.example.bookstory.dao.HistoryDAO;
import com.example.bookstory.vo.ContentComic;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DBModule {
    @Singleton
    @Provides
    public DBLocal dbLocal(Application application) {
        return DBLocal.getInstance(application);
    }

    @Singleton
    @Provides
    public BookDAO providerBookDAO(DBLocal dbLocal) {
        return dbLocal.bookDAO();
    }

    @Singleton
    @Provides
    public ChapterDAO chapterDAO(DBLocal dbLocal) {
        return dbLocal.chapterDAO();
    }

    @Singleton
    @Provides
    public HistoryDAO getHistoryDAO(DBLocal dbLocal) {
        return dbLocal.historyDAO();
    }

    @Singleton
    @Provides
    public ContentComicDAO getContentDAO(DBLocal dbLocal) {
        return dbLocal.contentComicDAO();
    }
    @Singleton
    @Provides
    public BookTypeDAO getBookTypeDAO(DBLocal dbLocal) {
        return dbLocal.bookTypeDAO();
    }
}
