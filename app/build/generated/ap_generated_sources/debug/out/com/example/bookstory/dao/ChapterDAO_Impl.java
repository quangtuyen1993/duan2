package com.example.bookstory.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.bookstory.vo.Chapter;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ChapterDAO_Impl implements ChapterDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Chapter> __insertionAdapterOfChapter;

  public ChapterDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChapter = new EntityInsertionAdapter<Chapter>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Chapter` (`id`,`date`,`name`,`content`,`idBook`,`chapterNumber`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Chapter value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getDate() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDate());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getContent() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getContent());
        }
        if (value.getIdBook() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getIdBook());
        }
        stmt.bindLong(6, value.getChapterNumber());
      }
    };
  }

  @Override
  public void insertChapter(final Chapter chapter) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChapter.insert(chapter);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertChapterList(final List<Chapter> chapter) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChapter.insert(chapter);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<Chapter> getChapterByBook(final String idBook, final int chapterNumber) {
    final String _sql = "SELECT * FROM CHAPTER WHERE idBook=? AND chapterNumber=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (idBook == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idBook);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, chapterNumber);
    return __db.getInvalidationTracker().createLiveData(new String[]{"CHAPTER"}, false, new Callable<Chapter>() {
      @Override
      public Chapter call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfIdBook = CursorUtil.getColumnIndexOrThrow(_cursor, "idBook");
          final int _cursorIndexOfChapterNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "chapterNumber");
          final Chapter _result;
          if(_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpContent;
            _tmpContent = _cursor.getString(_cursorIndexOfContent);
            final String _tmpIdBook;
            _tmpIdBook = _cursor.getString(_cursorIndexOfIdBook);
            final int _tmpChapterNumber;
            _tmpChapterNumber = _cursor.getInt(_cursorIndexOfChapterNumber);
            _result = new Chapter(_tmpId,_tmpDate,_tmpName,_tmpContent,_tmpIdBook,_tmpChapterNumber);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
