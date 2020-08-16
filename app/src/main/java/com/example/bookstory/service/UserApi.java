package com.example.bookstory.service;


import com.example.bookstory.di.annnotations.FragmentScope;
import com.example.bookstory.vo.User;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserApi {
    @POST("/users/login")
    @FormUrlEncoded
    Observable<User> onLoginEmailAndPassword(@Field("email") String email, @Field("password") String password);

    @POST("/users/loginOAuth")
    @FormUrlEncoded
    Call<User> onLoginGoogleOAuthor(@Field("idToken") String idToken);

    @POST("users/loginFacebook")
    @FormUrlEncoded
    Observable<User> onLoginFacebook(@Field("idToken") String idToken);


    @POST("users/register")
    @FormUrlEncoded
    Observable<User> onRegisterUser(@Field("email") String email, @Field("password") String password, @Field("name") String name);
}
