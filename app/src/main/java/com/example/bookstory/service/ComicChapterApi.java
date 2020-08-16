package com.example.bookstory.service;


import com.example.bookstory.vo.ComicChapter;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ComicChapterApi {
    @GET("/comic/chap")
    Observable<ComicChapter> fetchChap(@Query("idBook") String idBook, @Query("chapNumber") int chapNumber);
}
