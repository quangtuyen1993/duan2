package com.example.bookstory.util.pagination_booktype;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;

import com.example.bookstory.service.BuildRetrofit;
import com.example.bookstory.service.FeedApi;
import com.example.bookstory.vo.Book;
import com.example.bookstory.vo.Feed;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookDataSourceType extends PageKeyedDataSource<Integer, Book> {
    private MutableLiveData networkState;
    private MutableLiveData initialLoading;
    private FeedApi feedApi;
    private String _idBook;

    public BookDataSourceType(String _idBook) {
        this._idBook = _idBook;
        feedApi = BuildRetrofit.getInstance().create(FeedApi.class);
        networkState = new MutableLiveData();
        initialLoading = new MutableLiveData();
    }


    public MutableLiveData getNetworkState() {
        return networkState;
    }

    public MutableLiveData getInitialLoading() {
        return initialLoading;
    }

    public void setNetworkState(MutableLiveData networkState) {
        this.networkState = networkState;
    }

    public void setInitialLoading(MutableLiveData initialLoading) {
        this.initialLoading = initialLoading;
    }


    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Book> callback) {
        feedApi.onFetchPageBookByType(_idBook, 1, params.requestedLoadSize).enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if (response.isSuccessful())
                    if (response.body() != null)
                        callback.onResult(response.body().getBook(), 0, 2);
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Book> callback) {
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Book> callback) {
        feedApi.onFetchPageBookByType(_idBook, params.key, params.requestedLoadSize).enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if (response.isSuccessful()) {
                    int nextKey = params.key + 1;
                    if (response.body() != null && response.body().getLimit() > nextKey)
                        callback.onResult(response.body().getBook(), nextKey);
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.e("Main", t.getMessage());
            }
        });
    }
}
