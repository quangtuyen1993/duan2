package com.example.bookstory.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.bookstory.vo.BookType;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BookTypeDAO_Impl implements BookTypeDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BookType> __insertionAdapterOfBookType;

  public BookTypeDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBookType = new EntityInsertionAdapter<BookType>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `BookType` (`id`,`name`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BookType value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
      }
    };
  }

  @Override
  public void insertListBookType(final List<BookType> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBookType.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<BookType>> getBookLocal() {
    final String _sql = "SELECT * FROM BOOKTYPE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"BOOKTYPE"}, false, new Callable<List<BookType>>() {
      @Override
      public List<BookType> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final List<BookType> _result = new ArrayList<BookType>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BookType _item;
            _item = new BookType();
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
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
