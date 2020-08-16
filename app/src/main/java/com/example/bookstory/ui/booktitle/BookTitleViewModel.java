package com.example.bookstory.ui.booktitle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bookstory.di.annnotations.ActivityScope;
import com.example.bookstory.ui.comic.ComicActivity;
import com.example.bookstory.ui.readbook.ReadBookActivity;
import com.example.bookstory.vo.Book;
import com.example.bookstory.vo.BookType;

import java.util.List;

import javax.inject.Inject;

public class BookTitleViewModel extends ViewModel {
    private MutableLiveData<Book> bookLive = new MutableLiveData<>();

    @Inject
    @ActivityScope
    BookTitleActivity bookTitleActivity;

    public void onChangeScreen(Book book) {

        List<BookType> bookTypes = book.getBookType();
        boolean isComic = bookTypes.stream().anyMatch(bookType -> bookType.getName().equals("Truyen Tranh"));
        Intent intent;
        if (isComic) {
            intent = new Intent(bookTitleActivity, ComicActivity.class);
        } else {
            intent = new Intent(bookTitleActivity, ReadBookActivity.class);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("book", book);
        intent.putExtras(bundle);
        bookTitleActivity.startActivity(intent);
    }

    @Inject
    public BookTitleViewModel() {
    }

    public void setBookLive(Book book) {
        bookLive.setValue(book);
    }

    public MutableLiveData<Book> getBookLive() {
        return bookLive;
    }


}
