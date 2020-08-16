package com.example.bookstory.service;

import com.example.bookstory.vo.Feed;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FeedApi {
    @GET("/book/page")
    Call<Feed> onFetchPage(@Query("search") String search, @Query("page") int page, @Query("size") int size);

    @GET("/book/findType")
    Call<Feed> onFetchPageBookByType(
            @Query("_idBookType")
                    String idBook,
            @Query("page")
                    int page,
            @Query("size")
                    int size
    );

    @GET("/book/page")
    Observable<Feed> onFetchPageBook(
            @Query("search")
                    String idBook,
            @Query("page")
                    int page,
            @Query("size")
                    int size
    );
}
