package com.example.bookstory.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.bookstory.vo.Chapter;

import java.util.List;

@Dao
public interface ChapterDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertChapter(Chapter chapter);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertChapterList(List<Chapter> chapter);
    @Query("SELECT * FROM CHAPTER WHERE idBook=:idBook AND chapterNumber=:chapterNumber")
    LiveData<Chapter> getChapterByBook(String idBook, int chapterNumber);
}
