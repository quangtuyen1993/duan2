package com.example.bookstory.data.response;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.bookstory.service.UserApi;
import com.example.bookstory.service.UserWrapperApi;
import com.example.bookstory.vo.User;
import com.example.bookstory.vo.UserWrapper;
import javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;


public class UserWrapperRepository {
    private UserWrapperApi userWrapperApi;

    @Inject
    UserWrapperRepository(UserWrapperApi userWrapperApi) {
        this.userWrapperApi = userWrapperApi;
    }

    public Observable<UserWrapper> onLogin(String email, String password) {
        return userWrapperApi.onLogin(email, password);
    }

    public Observable<UserWrapper> onRegister(String email, String password, String name) {
        return userWrapperApi.onRegister(email, password, name);
    }

    public Observable<UserWrapper> onLoginGoogleAuthor(String idToken) {
        return userWrapperApi.onLoginGoogleOAuthor(idToken);
    }

    public Observable<UserWrapper> onLoginFaceBook(String id, String email,String name) {
        return userWrapperApi.onLoginFacebook(id,email,name);
    }
}
