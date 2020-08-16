package com.example.bookstory.service;

import com.example.bookstory.vo.History;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HistoryApi {
    @GET("/history")
    Observable<List<History>> getAllHistory();

    @GET("/history/user")
    Observable<List<History>> getHistoryByUser(
            @Query("idUser")
                    String idUser
    );

    @POST("/history")
    @FormUrlEncoded
    Observable<History> postHistory(
            @Field("idUser") String idUser,
            @Field("idBook") String idBook,
            @Field("chapterNumber") int chapter
    );
}
