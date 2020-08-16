package com.example.bookstory.dao;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bookstory.vo.Book;
import com.example.bookstory.vo.BookType;
import com.example.bookstory.vo.Chapter;
import com.example.bookstory.vo.ContentComic;
import com.example.bookstory.vo.History;

@Database(entities = {Book.class, BookType.class, Chapter.class, History.class, ContentComic.class}, version = 3, exportSchema = true)
public abstract class DBLocal extends RoomDatabase {
    private static DBLocal INSTANCE = null;

    public static DBLocal getInstance(Application application) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(application.getApplicationContext(), DBLocal.class, "BookStory")
                    .build();

        }
        return INSTANCE;
    }

    public abstract BookDAO bookDAO();

    public abstract ChapterDAO chapterDAO();

    public abstract HistoryDAO historyDAO();

    public abstract ContentComicDAO contentComicDAO();

    public abstract BookTypeDAO bookTypeDAO();
}
