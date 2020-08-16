package com.example.bookstory.ui.readbook;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.bookstory.data.response.ChapterRepository;
import com.example.bookstory.service.ChapterApi;
import com.example.bookstory.vo.Book;
import com.example.bookstory.vo.Chapter;
import com.example.bookstory.vo.History;
import com.example.bookstory.vo.User;
import com.example.bookstory.vo.UserLocalLogin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.BlockingBaseObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ReadBookViewModel extends ViewModel {

    private ChapterRepository chapterRepository;
    public MutableLiveData<Book> book = new MutableLiveData<>();
    private MutableLiveData<Integer> chapNumber = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable;
    private UserLocalLogin userLocalLogin;

    private MutableLiveData<Boolean> isLoading;

    public void setChapNumber(int number) {
        chapNumber.setValue(number);
    }

    public LiveData<Chapter> chapterLiveData = Transformations.switchMap(chapNumber, i -> {
        MutableLiveData<Chapter> chapterMutableLiveData = new MutableLiveData<>();
        if (book.getValue() == null) return chapterMutableLiveData;
        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(chapterRepository.getSingleChap(book.getValue().getId(), i)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(d->{
                    isLoading.postValue(true);
                })
                .subscribeWith(new DisposableObserver<Chapter>() {
                    @Override
                    public void onNext(Chapter chapter) {
                        chapterMutableLiveData.setValue(chapter);
                        chapterRepository.saveChapterLocal(chapter);
                        insertLocal(i);
                    }

                    @Override
                    public void onError(Throwable e) {
                        isLoading.postValue(false);
                    }

                    @Override
                    public void onComplete() {
                        isLoading.postValue(false);
                    }
                }));
        return chapterMutableLiveData;
    });

    public void onNext() {
        if (chapNumber.getValue() != null && chapNumber.getValue() < Objects.requireNonNull(book.getValue()).getChapters()) {
            chapNumber.setValue(chapNumber.getValue() + 1);
        }
    }

    public void onPre() {
        if (chapNumber.getValue() != null && chapNumber.getValue() > 1) {
            chapNumber.setValue(chapNumber.getValue() - 1);
        }
    }

    @Inject
    public ReadBookViewModel(ChapterRepository chapterRepository, UserLocalLogin userLocalLogin) {
        this.chapterRepository = chapterRepository;
        this.userLocalLogin = userLocalLogin;
        compositeDisposable = new CompositeDisposable();
        isLoading=new MutableLiveData<>();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }

    private void insertLocal(int i) {
        User user = userLocalLogin.userLoggerInUser();
        if (user != null) {
            compositeDisposable
                    .add(chapterRepository.postHistoryNetwork(user.getId(), book.getValue().getId(), i)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribeWith(new DisposableObserver<History>() {
                                @Override
                                public void onNext(History history) {
                                    Log.e("Main", "insert history success");
                                }

                                @Override
                                public void onError(Throwable e) {

                                }

                                @Override
                                public void onComplete() {

                                }
                            }));
        }
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }
}
