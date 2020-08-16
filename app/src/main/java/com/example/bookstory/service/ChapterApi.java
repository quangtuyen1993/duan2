package com.example.bookstory.service;

import com.example.bookstory.vo.Chapter;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ChapterApi {
    @GET("/chapter/{id}")
    Call<List<Chapter>> fetchAllChapterByIdBook(@Path("id") String id);

    @GET("/chapter/{id}")
    Observable<List<Chapter>> observerAllChapterByBook(@Path("id") String id);

    @GET("/chapter/find/{id}")
    Call<Chapter> fetchChapterById(@Path("id") String id);

    @GET("/chapter/chap")
    Observable<Chapter> fetchChap(@Query("idBook") String idBook, @Query("chapNumber") int chapNumber);

    @GET("chapter/downloadLocal")
    Observable<List<Chapter>> downloadChapter(
            @Query("idBook") String idBook,
            @Query("chapterNumber") int chapNumber
    );
}
