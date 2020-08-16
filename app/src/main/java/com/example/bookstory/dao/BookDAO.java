package com.example.bookstory.dao;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.bookstory.vo.Book;

import java.util.List;

@Dao
public interface BookDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllNewBook(Book... books);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertListBook(List<Book> books);


    @Query("DELETE FROM book")
    void deleteListBook();


    @Query("SELECT * FROM book")
    DataSource.Factory<Integer, Book> getAllBookLocal();

    @Query("SELECT * FROM book")
    LiveData<List<Book>> getAllBookLocalLive();
}
