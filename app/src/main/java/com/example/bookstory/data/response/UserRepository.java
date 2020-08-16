package com.example.bookstory.data.response;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bookstory.service.UserApi;
import com.example.bookstory.vo.User;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private UserApi userApi;

    @Inject
    public UserRepository(UserApi userApi) {
        this.userApi = userApi;
    }


    public MutableLiveData<User> onLoginGoogleAuthor(String idToken) {
        MutableLiveData<User> user = new MutableLiveData<>();
        userApi.onLoginGoogleOAuthor(idToken).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    user.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Main", t.toString());
            }
        });
        return user;
    }

    public Observable<User> onLoginEmailAndPassword(String email, String password) {
        return userApi.onLoginEmailAndPassword(email, password);
    }
    public Observable<User> onLoginFacebook(String token){
        return userApi.onLoginFacebook(token);
    }

    public Observable<User> onRegister(String email,String name,String password){
        return userApi.onRegisterUser(email,name,password);
    }
    public Observable<User> handlerResultLiveData(String email, String password) {
        return userApi.onLoginEmailAndPassword(email, password);
    }


}
