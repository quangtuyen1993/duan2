package com.example.bookstory.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.bookstory.vo.ContentComic;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ContentComicDAO_Impl implements ContentComicDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ContentComic> __insertionAdapterOfContentComic;

  public ContentComicDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfContentComic = new EntityInsertionAdapter<ContentComic>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `ContentComic` (`id`,`idChapter`,`position`,`imgBlob`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ContentComic value) {
        stmt.bindLong(1, value.id);
        if (value.idChapter == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.idChapter);
        }
        stmt.bindLong(3, value.position);
        if (value.imgBlob == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindBlob(4, value.imgBlob);
        }
      }
    };
  }

  @Override
  public void saveImg(final ContentComic contentComic) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfContentComic.insert(contentComic);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }
}
