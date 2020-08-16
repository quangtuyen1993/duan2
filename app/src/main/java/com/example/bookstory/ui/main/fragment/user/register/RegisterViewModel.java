package com.example.bookstory.ui.main.fragment.user.register;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bookstory.data.response.UserWrapperRepository;
import com.example.bookstory.data.response.UserWrapperRepository;
import com.example.bookstory.vo.User;
import com.example.bookstory.vo.UserWrapper;

import javax.inject.Inject;

import bolts.Bolts;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RegisterViewModel extends ViewModel {
    private UserWrapperRepository userRepository;

    @Inject
    public RegisterViewModel(UserWrapperRepository userRepository) {
        this.userRepository = userRepository;
        init();
    }


    public MutableLiveData<String> email;
    public MutableLiveData<String> password;
    public MutableLiveData<String> name;

    public MutableLiveData<Boolean> isLoading;

  public   MutableLiveData<String> error;
    MutableLiveData<Boolean> isSuccess;
    CompositeDisposable compositeDisposable;


    private void init() {
        email = new MutableLiveData<>();
        password = new MutableLiveData<>();
        name = new MutableLiveData<>();
        error = new MutableLiveData<>();
        isLoading = new MutableLiveData<>(false);
        isSuccess = new MutableLiveData<>(false);
        compositeDisposable = new CompositeDisposable();
    }


    void onRegister() {
        compositeDisposable.add(
                userRepository.onRegister(email.getValue(), password.getValue(), name.getValue())
                        .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(d -> isLoading.postValue(true))
                        .subscribeWith(
                                new DisposableObserver<UserWrapper>() {
                                    @Override
                                    public void onNext(UserWrapper user) {
                                        if (user.getUser() != null) {
                                            isSuccess.postValue(true);
                                        } else {
                                            error.setValue(user.getMessage());
                                        }
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        error.postValue(e.getMessage());
                                        isLoading.postValue(false);
                                    }

                                    @Override
                                    public void onComplete() {
                                        isLoading.postValue(false);
                                    }
                                }));

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
