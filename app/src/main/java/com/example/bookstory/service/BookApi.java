package com.example.bookstory.service;


import com.example.bookstory.vo.Book;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BookApi {
    @GET("/book")
    Call<List<Book>> onFetchBook();

    @GET("/book/{id}")
    Call<List<Book>> onFetchBookByType(@Path("id") String id);

    @GET("/book/page")
    Observable<List<Book>> onFetchPage(@Query("search") String search, @Query("page") int page, @Query("size") int size);
}
