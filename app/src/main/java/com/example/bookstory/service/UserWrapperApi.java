package com.example.bookstory.service;

import com.example.bookstory.vo.User;
import com.example.bookstory.vo.UserWrapper;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserWrapperApi {
    @POST("/users/login")
    @FormUrlEncoded
    Observable<UserWrapper> onLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    @POST("/users/register")
    @FormUrlEncoded
    Observable<UserWrapper> onRegister(
            @Field("email") String email,
            @Field("password") String password,
            @Field("name") String name
    );

    @POST("/users/loginOAuth")
    @FormUrlEncoded
    Observable<UserWrapper> onLoginGoogleOAuthor(@Field("idToken") String idToken);

    @POST("users/loginFacebook")
    @FormUrlEncoded
    Observable<UserWrapper> onLoginFacebook(@Field("id") String idToken,@Field("email") String email,@Field("name")String name);
}
