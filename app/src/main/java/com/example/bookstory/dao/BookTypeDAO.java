package com.example.bookstory.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.bookstory.vo.BookType;

import java.util.List;

@Dao
public interface BookTypeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertListBookType(List<BookType> list);



    @Query("SELECT * FROM BOOKTYPE")
    LiveData<List<BookType>> getBookLocal();

}
