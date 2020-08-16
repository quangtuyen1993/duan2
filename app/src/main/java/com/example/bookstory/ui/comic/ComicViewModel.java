package com.example.bookstory.ui.comic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.bookstory.dao.ContentComicDAO;
import com.example.bookstory.data.response.ComicChapterRepository;
import com.example.bookstory.vo.Book;
import com.example.bookstory.vo.ComicChapter;
import com.example.bookstory.vo.ContentComic;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ComicViewModel extends ViewModel {
    private ComicChapterRepository comicChapterRepository;

    MutableLiveData<Book> book;
    private MutableLiveData<Integer> chapNumber;
    LiveData<ComicChapter> comicChapter;
    private CompositeDisposable compositeDisposable;

    @Inject
    public ComicViewModel(ComicChapterRepository comicChapterRepository) {
        this.comicChapterRepository = comicChapterRepository;
        compositeDisposable = new CompositeDisposable();
        init();
    }


    private void init() {
        book = new MutableLiveData<>();
        chapNumber = new MutableLiveData<>(1);

        comicChapter = Transformations.switchMap(chapNumber, num -> {
            MutableLiveData<ComicChapter> mutableLiveData = new MutableLiveData<>();
            compositeDisposable.add(comicChapterRepository.fetchComicChapter(book.getValue().getId(), num)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<ComicChapter>() {
                        @Override
                        public void onNext(ComicChapter comicChapter) {
                            mutableLiveData.postValue(comicChapter);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    })
            );
            return mutableLiveData;
        });
    }

    public void onNext() {
        if (chapNumber.getValue() == null) return;
        if (chapNumber.getValue() < book.getValue().getComics()) {
            chapNumber.setValue(chapNumber.getValue() + 1);
        }
    }

    public void onPre() {
        if (chapNumber.getValue() == null) return;
        if (chapNumber.getValue() > 1) {
            chapNumber.setValue(chapNumber.getValue() - 1);
        }
    }

    public MutableLiveData<Integer> getChapNumber() {
        return chapNumber;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }

    public void insertContentComic(ContentComic contentComic) {
        comicChapterRepository.insertContentComic(contentComic);
    }
}
