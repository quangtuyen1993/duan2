package com.example.bookstory.dao;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DBLocal_Impl extends DBLocal {
  private volatile BookDAO _bookDAO;

  private volatile ChapterDAO _chapterDAO;

  private volatile HistoryDAO _historyDAO;

  private volatile ContentComicDAO _contentComicDAO;

  private volatile BookTypeDAO _bookTypeDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Book` (`id` TEXT NOT NULL, `bookType` TEXT, `name` TEXT, `status` TEXT, `translators` TEXT, `author` TEXT, `chapters` INTEGER NOT NULL, `des` TEXT, `imgUrl` TEXT, `dateStart` TEXT, `dateUpdate` TEXT, `chapterPosition` INTEGER NOT NULL, `comics` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `BookType` (`id` TEXT NOT NULL, `name` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Chapter` (`id` TEXT NOT NULL, `date` TEXT, `name` TEXT, `content` TEXT, `idBook` TEXT, `chapterNumber` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `History` (`id` TEXT NOT NULL, `idUser` TEXT, `book` TEXT, `chapterState` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ContentComic` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `idChapter` TEXT, `position` INTEGER NOT NULL, `imgBlob` BLOB)");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_ContentComic_idChapter_position` ON `ContentComic` (`idChapter`, `position`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f0cdb1309966e572f48e55f40eea7eed')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Book`");
        _db.execSQL("DROP TABLE IF EXISTS `BookType`");
        _db.execSQL("DROP TABLE IF EXISTS `Chapter`");
        _db.execSQL("DROP TABLE IF EXISTS `History`");
        _db.execSQL("DROP TABLE IF EXISTS `ContentComic`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsBook = new HashMap<String, TableInfo.Column>(13);
        _columnsBook.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("bookType", new TableInfo.Column("bookType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("translators", new TableInfo.Column("translators", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("author", new TableInfo.Column("author", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("chapters", new TableInfo.Column("chapters", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("des", new TableInfo.Column("des", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("imgUrl", new TableInfo.Column("imgUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("dateStart", new TableInfo.Column("dateStart", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("dateUpdate", new TableInfo.Column("dateUpdate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("chapterPosition", new TableInfo.Column("chapterPosition", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("comics", new TableInfo.Column("comics", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBook = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBook = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBook = new TableInfo("Book", _columnsBook, _foreignKeysBook, _indicesBook);
        final TableInfo _existingBook = TableInfo.read(_db, "Book");
        if (! _infoBook.equals(_existingBook)) {
          return new RoomOpenHelper.ValidationResult(false, "Book(com.example.bookstory.vo.Book).\n"
                  + " Expected:\n" + _infoBook + "\n"
                  + " Found:\n" + _existingBook);
        }
        final HashMap<String, TableInfo.Column> _columnsBookType = new HashMap<String, TableInfo.Column>(2);
        _columnsBookType.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookType.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBookType = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBookType = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBookType = new TableInfo("BookType", _columnsBookType, _foreignKeysBookType, _indicesBookType);
        final TableInfo _existingBookType = TableInfo.read(_db, "BookType");
        if (! _infoBookType.equals(_existingBookType)) {
          return new RoomOpenHelper.ValidationResult(false, "BookType(com.example.bookstory.vo.BookType).\n"
                  + " Expected:\n" + _infoBookType + "\n"
                  + " Found:\n" + _existingBookType);
        }
        final HashMap<String, TableInfo.Column> _columnsChapter = new HashMap<String, TableInfo.Column>(6);
        _columnsChapter.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChapter.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChapter.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChapter.put("content", new TableInfo.Column("content", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChapter.put("idBook", new TableInfo.Column("idBook", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChapter.put("chapterNumber", new TableInfo.Column("chapterNumber", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChapter = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesChapter = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChapter = new TableInfo("Chapter", _columnsChapter, _foreignKeysChapter, _indicesChapter);
        final TableInfo _existingChapter = TableInfo.read(_db, "Chapter");
        if (! _infoChapter.equals(_existingChapter)) {
          return new RoomOpenHelper.ValidationResult(false, "Chapter(com.example.bookstory.vo.Chapter).\n"
                  + " Expected:\n" + _infoChapter + "\n"
                  + " Found:\n" + _existingChapter);
        }
        final HashMap<String, TableInfo.Column> _columnsHistory = new HashMap<String, TableInfo.Column>(4);
        _columnsHistory.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistory.put("idUser", new TableInfo.Column("idUser", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistory.put("book", new TableInfo.Column("book", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistory.put("chapterState", new TableInfo.Column("chapterState", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHistory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHistory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHistory = new TableInfo("History", _columnsHistory, _foreignKeysHistory, _indicesHistory);
        final TableInfo _existingHistory = TableInfo.read(_db, "History");
        if (! _infoHistory.equals(_existingHistory)) {
          return new RoomOpenHelper.ValidationResult(false, "History(com.example.bookstory.vo.History).\n"
                  + " Expected:\n" + _infoHistory + "\n"
                  + " Found:\n" + _existingHistory);
        }
        final HashMap<String, TableInfo.Column> _columnsContentComic = new HashMap<String, TableInfo.Column>(4);
        _columnsContentComic.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContentComic.put("idChapter", new TableInfo.Column("idChapter", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContentComic.put("position", new TableInfo.Column("position", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContentComic.put("imgBlob", new TableInfo.Column("imgBlob", "BLOB", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysContentComic = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesContentComic = new HashSet<TableInfo.Index>(1);
        _indicesContentComic.add(new TableInfo.Index("index_ContentComic_idChapter_position", true, Arrays.asList("idChapter","position")));
        final TableInfo _infoContentComic = new TableInfo("ContentComic", _columnsContentComic, _foreignKeysContentComic, _indicesContentComic);
        final TableInfo _existingContentComic = TableInfo.read(_db, "ContentComic");
        if (! _infoContentComic.equals(_existingContentComic)) {
          return new RoomOpenHelper.ValidationResult(false, "ContentComic(com.example.bookstory.vo.ContentComic).\n"
                  + " Expected:\n" + _infoContentComic + "\n"
                  + " Found:\n" + _existingContentComic);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "f0cdb1309966e572f48e55f40eea7eed", "2c0f328a909798123ba10b5891f65c2e");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Book","BookType","Chapter","History","ContentComic");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Book`");
      _db.execSQL("DELETE FROM `BookType`");
      _db.execSQL("DELETE FROM `Chapter`");
      _db.execSQL("DELETE FROM `History`");
      _db.execSQL("DELETE FROM `ContentComic`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public BookDAO bookDAO() {
    if (_bookDAO != null) {
      return _bookDAO;
    } else {
      synchronized(this) {
        if(_bookDAO == null) {
          _bookDAO = new BookDAO_Impl(this);
        }
        return _bookDAO;
      }
    }
  }

  @Override
  public ChapterDAO chapterDAO() {
    if (_chapterDAO != null) {
      return _chapterDAO;
    } else {
      synchronized(this) {
        if(_chapterDAO == null) {
          _chapterDAO = new ChapterDAO_Impl(this);
        }
        return _chapterDAO;
      }
    }
  }

  @Override
  public HistoryDAO historyDAO() {
    if (_historyDAO != null) {
      return _historyDAO;
    } else {
      synchronized(this) {
        if(_historyDAO == null) {
          _historyDAO = new HistoryDAO_Impl(this);
        }
        return _historyDAO;
      }
    }
  }

  @Override
  public ContentComicDAO contentComicDAO() {
    if (_contentComicDAO != null) {
      return _contentComicDAO;
    } else {
      synchronized(this) {
        if(_contentComicDAO == null) {
          _contentComicDAO = new ContentComicDAO_Impl(this);
        }
        return _contentComicDAO;
      }
    }
  }

  @Override
  public BookTypeDAO bookTypeDAO() {
    if (_bookTypeDAO != null) {
      return _bookTypeDAO;
    } else {
      synchronized(this) {
        if(_bookTypeDAO == null) {
          _bookTypeDAO = new BookTypeDAO_Impl(this);
        }
        return _bookTypeDAO;
      }
    }
  }
}
