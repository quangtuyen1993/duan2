package com.example.bookstory.data.response;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.bookstory.dao.HistoryDAO;
import com.example.bookstory.service.HistoryApi;
import com.example.bookstory.vo.History;
import com.example.bookstory.vo.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class HistoryRepository {
    private HistoryApi historyApi;
    private HistoryDAO historyDAO;

    @Inject
    public HistoryRepository(HistoryApi historyApi, HistoryDAO historyDAO) {
        this.historyApi = historyApi;
        this.historyDAO = historyDAO;
    }

    public Observable<List<History>> getHistoryByUser(User user) {
        String idUser = user.getId();
        return historyApi.getHistoryByUser(idUser);
    }

    public void insertHistoryLocal(List<History> histories) {
        AsyncTask.execute(() -> {
            historyDAO.insertListHistory(histories);
        });
    }

    public LiveData<List<History>> historyLocal(User user) {
        String idUser = user.getId();
        return historyDAO.getListHistoryByUser(idUser);
    }
}
