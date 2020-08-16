package com.example.bookstory.util.pagination;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.example.bookstory.vo.Book;

public class BookFactory extends DataSource.Factory {

    private MutableLiveData<BookDataSource> mutableLiveData;
    private String input;
    private BookDataSource bookDataSource;

    public BookFactory(String input) {
        this.input = input;
        mutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<BookDataSource> getMutableLiveData() {
        return mutableLiveData;
    }

    @Override
    public DataSource<Integer, Book> create() {
        bookDataSource = new BookDataSource(input);
        mutableLiveData.postValue(bookDataSource);
        return bookDataSource;
    }
}
