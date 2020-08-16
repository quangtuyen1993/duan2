package com.example.bookstory.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.bookstory.vo.History;
import com.example.bookstory.vo.User;

import java.util.List;

@Dao
public interface HistoryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertListHistory(List<History> history);

    @Query("SELECT * from history WHERE idUser=:idUser ")
    LiveData<List<History>> getListHistoryByUser(String idUser);
}
