package com.example.bookstory.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.bookstory.vo.Book;
import com.example.bookstory.vo.BookType;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BookDAO_Impl implements BookDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Book> __insertionAdapterOfBook;

  private final SharedSQLiteStatement __preparedStmtOfDeleteListBook;

  public BookDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBook = new EntityInsertionAdapter<Book>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Book` (`id`,`bookType`,`name`,`status`,`translators`,`author`,`chapters`,`des`,`imgUrl`,`dateStart`,`dateUpdate`,`chapterPosition`,`comics`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Book value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        final String _tmp;
        _tmp = BookTypeConvert.storeBookTypeToString(value.getBookType());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStatus());
        }
        if (value.getTranslators() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTranslators());
        }
        if (value.getAuthor() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAuthor());
        }
        stmt.bindLong(7, value.getChapters());
        if (value.getDes() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDes());
        }
        if (value.getImgUrl() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getImgUrl());
        }
        if (value.getDateStart() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getDateStart());
        }
        if (value.getDateUpdate() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDateUpdate());
        }
        stmt.bindLong(12, value.getChapterPosition());
        stmt.bindLong(13, value.getComics());
      }
    };
    this.__preparedStmtOfDeleteListBook = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM book";
        return _query;
      }
    };
  }

  @Override
  public void insertAllNewBook(final Book... books) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBook.insert(books);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertListBook(final List<Book> books) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBook.insert(books);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteListBook() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteListBook.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteListBook.release(_stmt);
    }
  }

  @Override
  public DataSource.Factory<Integer, Book> getAllBookLocal() {
    final String _sql = "SELECT * FROM book";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new DataSource.Factory<Integer, Book>() {
      @Override
      public LimitOffsetDataSource<Book> create() {
        return new LimitOffsetDataSource<Book>(__db, _statement, false , "book") {
          @Override
          protected List<Book> convertRows(Cursor cursor) {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfBookType = CursorUtil.getColumnIndexOrThrow(cursor, "bookType");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(cursor, "name");
            final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(cursor, "status");
            final int _cursorIndexOfTranslators = CursorUtil.getColumnIndexOrThrow(cursor, "translators");
            final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(cursor, "author");
            final int _cursorIndexOfChapters = CursorUtil.getColumnIndexOrThrow(cursor, "chapters");
            final int _cursorIndexOfDes = CursorUtil.getColumnIndexOrThrow(cursor, "des");
            final int _cursorIndexOfImgUrl = CursorUtil.getColumnIndexOrThrow(cursor, "imgUrl");
            final int _cursorIndexOfDateStart = CursorUtil.getColumnIndexOrThrow(cursor, "dateStart");
            final int _cursorIndexOfDateUpdate = CursorUtil.getColumnIndexOrThrow(cursor, "dateUpdate");
            final int _cursorIndexOfChapterPosition = CursorUtil.getColumnIndexOrThrow(cursor, "chapterPosition");
            final int _cursorIndexOfComics = CursorUtil.getColumnIndexOrThrow(cursor, "comics");
            final List<Book> _res = new ArrayList<Book>(cursor.getCount());
            while(cursor.moveToNext()) {
              final Book _item;
              final String _tmpId;
              _tmpId = cursor.getString(_cursorIndexOfId);
              final List<BookType> _tmpBookType;
              final String _tmp;
              _tmp = cursor.getString(_cursorIndexOfBookType);
              _tmpBookType = BookTypeConvert.storeStringToBookType(_tmp);
              final String _tmpName;
              _tmpName = cursor.getString(_cursorIndexOfName);
              final String _tmpStatus;
              _tmpStatus = cursor.getString(_cursorIndexOfStatus);
              final String _tmpTranslators;
              _tmpTranslators = cursor.getString(_cursorIndexOfTranslators);
              final String _tmpAuthor;
              _tmpAuthor = cursor.getString(_cursorIndexOfAuthor);
              final int _tmpChapters;
              _tmpChapters = cursor.getInt(_cursorIndexOfChapters);
              final String _tmpDes;
              _tmpDes = cursor.getString(_cursorIndexOfDes);
              final String _tmpImgUrl;
              _tmpImgUrl = cursor.getString(_cursorIndexOfImgUrl);
              final String _tmpDateStart;
              _tmpDateStart = cursor.getString(_cursorIndexOfDateStart);
              final String _tmpDateUpdate;
              _tmpDateUpdate = cursor.getString(_cursorIndexOfDateUpdate);
              final int _tmpChapterPosition;
              _tmpChapterPosition = cursor.getInt(_cursorIndexOfChapterPosition);
              final int _tmpComics;
              _tmpComics = cursor.getInt(_cursorIndexOfComics);
              _item = new Book(_tmpId,_tmpBookType,_tmpName,_tmpStatus,_tmpTranslators,_tmpAuthor,_tmpChapters,_tmpDes,_tmpImgUrl,_tmpDateStart,_tmpDateUpdate,_tmpChapterPosition,_tmpComics);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public LiveData<List<Book>> getAllBookLocalLive() {
    final String _sql = "SELECT * FROM book";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"book"}, false, new Callable<List<Book>>() {
      @Override
      public List<Book> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfBookType = CursorUtil.getColumnIndexOrThrow(_cursor, "bookType");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfTranslators = CursorUtil.getColumnIndexOrThrow(_cursor, "translators");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfChapters = CursorUtil.getColumnIndexOrThrow(_cursor, "chapters");
          final int _cursorIndexOfDes = CursorUtil.getColumnIndexOrThrow(_cursor, "des");
          final int _cursorIndexOfImgUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imgUrl");
          final int _cursorIndexOfDateStart = CursorUtil.getColumnIndexOrThrow(_cursor, "dateStart");
          final int _cursorIndexOfDateUpdate = CursorUtil.getColumnIndexOrThrow(_cursor, "dateUpdate");
          final int _cursorIndexOfChapterPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "chapterPosition");
          final int _cursorIndexOfComics = CursorUtil.getColumnIndexOrThrow(_cursor, "comics");
          final List<Book> _result = new ArrayList<Book>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Book _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final List<BookType> _tmpBookType;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfBookType);
            _tmpBookType = BookTypeConvert.storeStringToBookType(_tmp);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpTranslators;
            _tmpTranslators = _cursor.getString(_cursorIndexOfTranslators);
            final String _tmpAuthor;
            _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            final int _tmpChapters;
            _tmpChapters = _cursor.getInt(_cursorIndexOfChapters);
            final String _tmpDes;
            _tmpDes = _cursor.getString(_cursorIndexOfDes);
            final String _tmpImgUrl;
            _tmpImgUrl = _cursor.getString(_cursorIndexOfImgUrl);
            final String _tmpDateStart;
            _tmpDateStart = _cursor.getString(_cursorIndexOfDateStart);
            final String _tmpDateUpdate;
            _tmpDateUpdate = _cursor.getString(_cursorIndexOfDateUpdate);
            final int _tmpChapterPosition;
            _tmpChapterPosition = _cursor.getInt(_cursorIndexOfChapterPosition);
            final int _tmpComics;
            _tmpComics = _cursor.getInt(_cursorIndexOfComics);
            _item = new Book(_tmpId,_tmpBookType,_tmpName,_tmpStatus,_tmpTranslators,_tmpAuthor,_tmpChapters,_tmpDes,_tmpImgUrl,_tmpDateStart,_tmpDateUpdate,_tmpChapterPosition,_tmpComics);
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
