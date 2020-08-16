package com.example.bookstory.ui.main.fragment.home.title;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bookstory.vo.Book;

import javax.inject.Inject;

public class BookTitleViewModel extends ViewModel {

    @Inject
    BookTitleViewModel() {
    }

    public MutableLiveData<Book> bookLiveData = new MutableLiveData<>();

    public void setBook(Book book) {
        bookLiveData.postValue(book);
    }

}
