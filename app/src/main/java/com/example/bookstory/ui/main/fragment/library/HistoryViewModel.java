package com.example.bookstory.ui.main.fragment.library;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.bookstory.data.response.ChapterRepository;
import com.example.bookstory.data.response.HistoryRepository;
import com.example.bookstory.vo.Book;
import com.example.bookstory.vo.Chapter;
import com.example.bookstory.vo.History;
import com.example.bookstory.vo.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HistoryViewModel extends ViewModel {
    private HistoryRepository historyRepository;
    private ChapterRepository chapterRepository;
    private MutableLiveData<User> user = new MutableLiveData<>();
    private LiveData<List<History>> historyLocal;
    private CompositeDisposable compositeDisposable;

    @Inject
    HistoryViewModel(HistoryRepository historyRepository, ChapterRepository chapterRepository) {
        this.historyRepository = historyRepository;
        this.chapterRepository=chapterRepository;
        init();
    }


    private void init() {
        compositeDisposable = new CompositeDisposable();
        historyLocal = Transformations.switchMap(user, user -> {
            if (user == null) return new MutableLiveData<>();
            else return historyRepository.historyLocal(user);
        });
    }

    void fetchListNetwork() {
        if (user.getValue() == null) return;
        compositeDisposable.add(
                historyRepository.getHistoryByUser(user.getValue())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<List<History>>() {
                            @Override
                            public void onNext(List<History> histories) {
                                historyRepository.insertHistoryLocal(histories);
                                histories.forEach(history -> {
                                   Book book= history.getBook();
                                   asyncChapter(book.getId(),history.getChapterState());
                                });
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(getClass().toString(), e.getMessage());
                            }

                            @Override
                            public void onComplete() {

                            }
                        })
        );

    }

    LiveData<List<History>> getHistoryLocal() {
        return historyLocal;
    }


    public void setUser(User user) {
        this.user.setValue(user);
    }
    public void asyncChapter(String idBook,int chapCurrent){
        compositeDisposable.add(
                chapterRepository.downloadChapter(idBook,chapCurrent)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<List<Chapter>>(){

                    @Override
                    public void onNext(List<Chapter> list) {
                        chapterRepository.saveChapterLocalList(list);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Async","failed");

                    }

                    @Override
                    public void onComplete() {
                        Log.e("Async","complete");

                    }
                })
        );
    }
}
