package com.example.bookstory.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.bookstory.vo.Book;
import com.example.bookstory.vo.History;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class HistoryDAO_Impl implements HistoryDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<History> __insertionAdapterOfHistory;

  public HistoryDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHistory = new EntityInsertionAdapter<History>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `History` (`id`,`idUser`,`book`,`chapterState`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, History value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getIdUser() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getIdUser());
        }
        final String _tmp;
        _tmp = BookConvert.storeBookTypeToString(value.getBook());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
        stmt.bindLong(4, value.getChapterState());
      }
    };
  }

  @Override
  public void insertListHistory(final List<History> history) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfHistory.insert(history);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<History>> getListHistoryByUser(final String idUser) {
    final String _sql = "SELECT * from history WHERE idUser=? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idUser == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idUser);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"history"}, false, new Callable<List<History>>() {
      @Override
      public List<History> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfIdUser = CursorUtil.getColumnIndexOrThrow(_cursor, "idUser");
          final int _cursorIndexOfBook = CursorUtil.getColumnIndexOrThrow(_cursor, "book");
          final int _cursorIndexOfChapterState = CursorUtil.getColumnIndexOrThrow(_cursor, "chapterState");
          final List<History> _result = new ArrayList<History>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final History _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpIdUser;
            _tmpIdUser = _cursor.getString(_cursorIndexOfIdUser);
            final Book _tmpBook;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfBook);
            _tmpBook = BookConvert.storeStringToBookType(_tmp);
            final int _tmpChapterState;
            _tmpChapterState = _cursor.getInt(_cursorIndexOfChapterState);
            _item = new History(_tmpId,_tmpIdUser,_tmpBook,_tmpChapterState);
            _result.add(_item);
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
