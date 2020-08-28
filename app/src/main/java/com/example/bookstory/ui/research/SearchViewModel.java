package com.example.bookstory.ui.research;

import com.example.bookstory.dao.BookDAO;
import com.example.bookstory.data.response.BookRepository;
import com.example.bookstory.data.response.FeedRepository;
import com.example.bookstory.vo.Book;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class SearchViewModel extends ViewModel
{
    BookRepository bookRepository;
    BookDAO bookLocal;
    FeedRepository feedRepository;

    MutableLiveData<String>search=new MutableLiveData<>();
    LiveData<List<Book>> listSearch;


    @Inject
    SearchViewModel(BookRepository bookRepository, BookDAO bookDAO, FeedRepository feedRepository) {
        this.bookRepository = bookRepository;
        this.bookLocal = bookDAO;
        this.feedRepository = feedRepository;
        init();

    }
    void init(){
listSearch= Transformations.switchMap(search,string->{
   return  bookRepository.getBookByName(string);
});
    }
}
