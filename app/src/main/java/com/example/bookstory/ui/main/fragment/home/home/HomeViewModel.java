package com.example.bookstory.ui.main.fragment.home.home;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.bookstory.dao.BookDAO;
import com.example.bookstory.data.response.BookRepository;
import com.example.bookstory.data.response.FeedRepository;
import com.example.bookstory.vo.Book;
import com.example.bookstory.vo.Feed;
import com.example.bookstory.vo.PageKey;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {
    private BookRepository bookRepository;
    private FeedRepository feedRepository;

    private BookDAO bookLocal;
    private CompositeDisposable compositeDisposable;

    LiveData<List<Book>> localLive;

    MutableLiveData<Integer> page = new MutableLiveData<>(0);
    MutableLiveData<Double> limit = new MutableLiveData<>(1.0);
    MutableLiveData<String> keyWord = new MutableLiveData<>("");
    MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);

    private MutableLiveData<List<Book>> resultSearch;

    private MutableLiveData<String> newSearch;
    private MutableLiveData<String> preSearch;

    static final int BOOK_SIZE = 10;

    LiveData<List<Book>> result;

    private MutableLiveData<PageKey> pageKey;
    private MutableLiveData<Boolean> searchMode;

    public MutableLiveData<PageKey> getPageKey() {
        return pageKey;
    }

    private void init() {
        compositeDisposable = new CompositeDisposable();
        newSearch = new MutableLiveData<>("");
        preSearch = new MutableLiveData<>("");
        isLoading = new MutableLiveData<>(false);
        searchMode = new MutableLiveData<>(false);
        resultSearch = new MutableLiveData<>();
        pageKey = new MutableLiveData<>(new PageKey(1, ""));
        result = Transformations.switchMap(pageKey, this::onResult);
        localLive = bookLocal.getAllBookLocalLive();

    }

    private LiveData<List<Book>> onResult(PageKey pk) {
        preSearch.setValue(newSearch.getValue());
        newSearch.setValue(pk.getKey());
        if (!Objects.equals(preSearch.getValue(), newSearch.getValue())) {
            resultSearch = new MutableLiveData<>();
            pk.setPage(1);
            pageKey.setValue(pk);
        } else {
            if (isLoading.getValue() != null && !isLoading.getValue())
                compositeDisposable.add(
                        feedRepository.downloadBookInPage(pk.getKey(), pk.getPage(), BOOK_SIZE).
                                subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .doOnSubscribe(d -> isLoading.postValue(true))
                                .subscribeWith(new DisposableObserver<Feed>() {
                                    @Override
                                    public void onNext(Feed feed) {
                                        List<Book> list = new ArrayList<>();
                                        if (resultSearch.getValue() != null) {
                                            list = resultSearch.getValue();
                                        }
                                        limit.setValue(feed.getLimit());
                                        list.addAll(feed.getBook());
                                        page.setValue(feed.getPage());
                                        resultSearch.setValue(list);
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        isLoading.postValue(false);
                                    }

                                    @Override
                                    public void onComplete() {
                                        isLoading.setValue(false);
                                    }
                                })
                );
        }
        return resultSearch;

    }

    void onTestLoadMore() {
        PageKey pk = pageKey.getValue();
        if (pk.getPage() < limit.getValue() && !isLoading.getValue()) {
            pk.setPage(pk.getPage() + 1);
            pageKey.setValue(pk);
        }
    }

    void onSearch(String search) {
        PageKey pk = pageKey.getValue();
        assert pk != null;
        pk.setKey(search);
        pageKey.postValue(pk);
    }


    LiveData<List<Book>> loadLocal() {
        return this.localLive;
    }

    void insertNewListDao(List<Book> books) {
        Thread insert = new Thread(() -> {
            bookLocal.deleteListBook();
            bookLocal.insertListBook(books);

        });
        insert.start();
    }



    @Inject
    HomeViewModel(BookRepository bookRepository, BookDAO bookDAO, FeedRepository feedRepository) {
        this.bookRepository = bookRepository;
        this.bookLocal = bookDAO;
        this.feedRepository = feedRepository;
        init();

    }

    void refresh() {
        resultSearch = new MutableLiveData<>();
        pageKey.setValue(new PageKey(1, ""));
    }

    MutableLiveData<Boolean> getSearchMode() {
        return searchMode;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
