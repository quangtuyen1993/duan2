package com.example.bookstory.util.pagination;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;

import com.example.bookstory.dao.BookDAO;
import com.example.bookstory.service.BuildRetrofit;
import com.example.bookstory.service.FeedApi;
import com.example.bookstory.vo.Book;
import com.example.bookstory.vo.Feed;
import com.example.bookstory.vo.LoadPage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookDataSource extends PageKeyedDataSource<Integer, Book> {

    private FeedApi feedApi;
    private String query;
    BookDAO bookDAO;

    public MutableLiveData<LoadPage> loadPage;
    private LoadPage loadInfo = new LoadPage(0, 0);

    public BookDataSource(String query) {
        this.query = query;
        feedApi = BuildRetrofit.getInstance().create(FeedApi.class);
        bookDAO = BuildRetrofit.getInstance().create(BookDAO.class);
        loadPage = new MutableLiveData<>(loadInfo);
    }


    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Book> callback) {
        feedApi.onFetchPage(query, 1, params.requestedLoadSize).enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                if (response.isSuccessful())
                    if (response.body() != null) {
                        callback.onResult(response.body().getBook(), 0, 2);
                        loadInfo.setPageLimit((int) response.body().getLimit());
                        loadInfo.setPageLoadCurrent(1);
                        loadPage.postValue(loadInfo);
                    }
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
        feedApi.onFetchPage(query, params.key, params.requestedLoadSize).enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {

                if (response.isSuccessful() && params.key < response.body().getLimit() + 1) {
                    int nextKey = params.key + 1;
                    if (response.body() != null) {
                        callback.onResult(response.body().getBook(), nextKey);
                        loadInfo.setPageLoadCurrent(params.key);
                        loadPage.postValue(loadInfo);
                    }
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.e("Main", t.getMessage());
            }
        });
    }
}
