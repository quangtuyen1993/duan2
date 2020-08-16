package com.example.bookstory.ui.main.fragment.user.userloginmanager;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bookstory.data.response.UserWrapperRepository;
import com.example.bookstory.service.UserWrapperApi;
import com.example.bookstory.util.Event;
import com.example.bookstory.vo.User;
import com.example.bookstory.vo.UserWrapper;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class UserLoginManagerViewModel extends ViewModel {
    private UserWrapperRepository wrapperRepository;

    MutableLiveData<String> error;
    MutableLiveData<Boolean> isLoading;
    MutableLiveData<User> userOAuth;
    MutableLiveData<User> userEmail;
    MutableLiveData<User> userFacebook;
    private CompositeDisposable compositeDisposable;

    @Inject
    UserLoginManagerViewModel(UserWrapperRepository userRepository) {
        this.wrapperRepository = userRepository;
        init();
    }

    private void init() {
        compositeDisposable = new CompositeDisposable();

        error = new MutableLiveData<>();

        userOAuth = new MutableLiveData<>();
        userEmail = new MutableLiveData<>();
        userFacebook = new MutableLiveData<>();
        isLoading = new MutableLiveData<>(false);
    }

    void onLoginUserLoginOAuth(String idTk) {
        compositeDisposable.add(
                wrapperRepository.onLoginGoogleAuthor(idTk)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable -> isLoading.setValue(true))
                        .subscribeWith(new DisposableObserver<UserWrapper>() {
                            @Override
                            public void onNext(UserWrapper userWrapper) {
                                userOAuth.postValue(userWrapper.getUser());
                            }

                            @Override
                            public void onError(Throwable e) {
                                isLoading.setValue(false);
                                error.postValue(e.getMessage());
                            }

                            @Override
                            public void onComplete() {
                                isLoading.setValue(false);
                            }
                        })

        );
    }

    void onLogin(String email, String password) {
        compositeDisposable.add(
                wrapperRepository.onLogin(email, password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(d -> isLoading.postValue(true))
                        .subscribeWith(new DisposableObserver<UserWrapper>() {
                            @Override
                            public void onNext(UserWrapper userWrapper) {
                                if (userWrapper.getUser() != null)
                                    userEmail.postValue(userWrapper.getUser());
                                else
                                    error.postValue(userWrapper.getMessage());
                            }

                            @Override
                            public void onError(Throwable e) {
                                isLoading.postValue(false);
                            }

                            @Override
                            public void onComplete() {
                                isLoading.postValue(false);
                            }
                        })
        );
    }

    public void onLoginFacebook(String id, String email, String name) {
        compositeDisposable.add(
                wrapperRepository.onLoginFaceBook(id, email, name)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<UserWrapper>() {
                            @Override
                            public void onNext(UserWrapper userWrapper) {
                                userFacebook.setValue(userWrapper.getUser());
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }


}
