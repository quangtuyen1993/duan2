package com.example.bookstory.util.pagination_booktype;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.example.bookstory.vo.Book;

public class BookFactoryType extends DataSource.Factory {

    private MutableLiveData<BookDataSourceType> mutableLiveData;
    private String idBook;
    private BookDataSourceType bookDataSource;

    public BookFactoryType(String idBook) {
        this.idBook = idBook;
        mutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<BookDataSourceType> getMutableLiveData() {
        return mutableLiveData;
    }

    @Override
    public DataSource<Integer, Book> create() {
        bookDataSource = new BookDataSourceType(idBook);
        mutableLiveData.postValue(bookDataSource);
        return bookDataSource;
    }
}
