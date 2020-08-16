package com.example.bookstory.ui.main.fragment.category.category;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bookstory.data.response.BookTypeRepository;
import com.example.bookstory.vo.BookType;

import java.util.List;

import javax.inject.Inject;

public class BookTypeViewModel extends ViewModel {
    private BookTypeRepository bookTypeRepository;
    private LiveData<List<BookType>> bookTypeNetwork;
    private LiveData<List<BookType>> bookTypeLocal;

    @Inject
    public BookTypeViewModel(BookTypeRepository bookTypeRepository) {
        this.bookTypeRepository = bookTypeRepository;
        init();
    }

    private void init() {
        bookTypeNetwork = bookTypeRepository.fetchAllBook();
        bookTypeLocal = bookTypeRepository.fetchAllBookLocal();
    }

    //get all data
    public LiveData<List<BookType>> getBookTypeNetwork() {
        return this.bookTypeNetwork;
    }

    public LiveData<List<BookType>> getBookTypeLocal() {
        return bookTypeLocal;
    }

    public void onAsyncLocal(List<BookType> bookTypes) {
        bookTypeRepository.onAsyncLocalBookType(bookTypes);
    }
}
