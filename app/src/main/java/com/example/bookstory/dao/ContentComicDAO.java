package com.example.bookstory.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.bookstory.vo.ContentComic;

import javax.inject.Inject;

@Dao
public interface ContentComicDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveImg(ContentComic contentComic);
}
