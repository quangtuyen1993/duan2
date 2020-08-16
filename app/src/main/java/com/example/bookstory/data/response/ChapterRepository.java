package com.example.bookstory.data.response;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bookstory.dao.ChapterDAO;
import com.example.bookstory.dao.HistoryDAO;
import com.example.bookstory.service.ChapterApi;
import com.example.bookstory.service.HistoryApi;
import com.example.bookstory.vo.Chapter;
import com.example.bookstory.vo.History;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapterRepository {
    private ChapterApi chapterApi;
    private ChapterDAO chapterDAO;
    private HistoryApi historyApi;

    @Inject
    public ChapterRepository(ChapterApi chapterApi, ChapterDAO chapterDAO, HistoryApi historyApi) {
        this.chapterApi = chapterApi;
        this.chapterDAO = chapterDAO;
        this.historyApi = historyApi;
    }

    public MutableLiveData<List<Chapter>> fetchAllChapterByBook(String idBook) {
        MutableLiveData<List<Chapter>> chapterMutableLiveData = new MutableLiveData<>();
        chapterApi.fetchAllChapterByIdBook(idBook).enqueue(new Callback<List<Chapter>>() {
            @Override
            public void onResponse(Call<List<Chapter>> call, Response<List<Chapter>> response) {
                if (response.isSuccessful()) {
                    chapterMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Chapter>> call, Throwable t) {
                Log.e("ChapterReponsitory", t.getMessage());
            }
        });

        return chapterMutableLiveData;
    }

    public MutableLiveData<Chapter> getChapterById(String id) {
        MutableLiveData<Chapter> mutableLiveData = new MutableLiveData<>();
        chapterApi.fetchChapterById(id).enqueue(new Callback<Chapter>() {
            @Override
            public void onResponse(Call<Chapter> call, Response<Chapter> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Chapter> call, Throwable t) {
                Log.e("ChapterRepository", t.getMessage());
            }
        });
        return mutableLiveData;
    }

    public Observable<List<Chapter>> getAllChapter(String idBook) {
        return chapterApi.observerAllChapterByBook(idBook);
    }

    public Observable<Chapter> getSingleChap(String idBook, int idChap) {
        return chapterApi.fetchChap(idBook, idChap);
    }

    public Observable<History> postHistoryNetwork(String idUser, String idBook, int chapterNumber) {
        return historyApi.postHistory(idUser, idBook, chapterNumber);
    }

    public void saveChapterLocal(Chapter chapter) {
        AsyncTask.execute(() -> {
            chapterDAO.insertChapter(chapter);
        });
    }
    public void saveChapterLocalList(List<Chapter> chapter) {
        AsyncTask.execute(() -> {
            chapterDAO.insertChapterList(chapter);
        });
    }
    public LiveData<Chapter> getChapterLocal(String idBook, int number) {
        return chapterDAO.getChapterByBook(idBook, number);
    }

    public Observable<List<Chapter>> downloadChapter(String idBook,int chapterNumber){
        return chapterApi.downloadChapter(idBook, chapterNumber);
    }
}
