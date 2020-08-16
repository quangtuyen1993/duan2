package com.example.bookstory.ui.main.fragment.category.categorybook;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.example.bookstory.data.response.BookRepository;
import com.example.bookstory.util.pagination_booktype.BookFactoryType;
import com.example.bookstory.vo.Book;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BookTypeBookViewModel extends ViewModel {
    private BookRepository bookRepository;
    private CompositeDisposable compositeDisposable;
    private Executor executor;
    public LiveData<PagedList<Book>> bookLiveData;
    private BookFactoryType bookFactory;

    private LiveData<List<Book>> booksLocal;
    private LiveData<List<Book>> booksNetwork;

    MutableLiveData<String> keyWord;
//    LiveData<PagedList<Book>> search = Transformations.switchMap(keyWord, this::loadData);

//    private LiveData<PagedList<Book>> loadData(String input) {
//        bookFactory = new BookFactoryType(input);
//        executor = Executors.newFixedThreadPool(1);
//        PagedList.Config pageConfig = new PagedList.Config.Builder()
//                .setEnablePlaceholders(false)
//                .setPageSize(5)
//                .build();
//        bookLiveData = (new LivePagedListBuilder<Integer, Book>(bookFactory, pageConfig)
//                .setFetchExecutor(executor)
//                .build());
//        return bookLiveData;
//    }

    @Inject
    BookTypeBookViewModel(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        init();
    }

    private void init() {
        keyWord = new MutableLiveData<>();
        compositeDisposable = new CompositeDisposable();
        booksLocal = bookRepository.getAllBookLocal();
        booksNetwork = Transformations.switchMap(keyWord, type -> {
            if (keyWord == null) return new MutableLiveData<>();
            else {
                return bookRepository.getBookByType(type);
            }
        });
    }

    public LiveData<List<Book>> getBooksLocal() {
        return this.booksLocal;
    }

    public LiveData<List<Book>> getBooksNetwork() {
        return this.booksNetwork;
    }
}
