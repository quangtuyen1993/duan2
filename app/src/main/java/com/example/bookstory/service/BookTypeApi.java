package com.example.bookstory.service;

import com.example.bookstory.vo.BookType;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BookTypeApi {
    @GET("/bookType")
    Call<List<BookType>> onFetchBookType();

}
