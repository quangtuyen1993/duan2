package com.example.bookstory.data.response;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bookstory.service.FeedApi;
import com.example.bookstory.vo.Feed;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedRepository {
    private FeedApi feedApi;

    @Inject
    FeedRepository(FeedApi feedApi) {
        this.feedApi = feedApi;
    }

    public Observable<Feed> downloadBookInPage(String key,int perPage, int size) {
        return feedApi.onFetchPageBook(key, perPage, size);
    }
}
