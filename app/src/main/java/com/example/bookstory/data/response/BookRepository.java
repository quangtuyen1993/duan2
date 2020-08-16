package com.example.bookstory.data.response;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bookstory.dao.BookDAO;
import com.example.bookstory.service.BookApi;
import com.example.bookstory.service.FeedApi;
import com.example.bookstory.vo.Book;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookRepository {
    private FeedApi feedApi;
    private BookApi bookApi;
    private BookDAO bookDAO;

    @Inject
    BookRepository(BookApi bookApi, FeedApi feedApi, BookDAO bookDAO) {
        this.bookApi = bookApi;
        this.feedApi = feedApi;
        this.bookDAO = bookDAO;
    }


    public Observable<List<Book>> downloadBookInPage(int perPage, int size) {
        return bookApi.onFetchPage("", perPage, size);
    }

    public MutableLiveData<List<Book>> getAllBook() {

        MutableLiveData<List<Book>> mutableLiveData = new MutableLiveData<>();
        bookApi.onFetchBook().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(@NotNull Call<List<Book>> call, @NotNull Response<List<Book>> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<List<Book>> call, @NotNull Throwable t) {
                Log.e("Home Repository", Objects.requireNonNull(t.getMessage()));
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<List<Book>> getBookByName(String key) {
        MutableLiveData<List<Book>> mutableLiveData = new MutableLiveData<>();
        bookApi.onFetchBook().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(@NotNull Call<List<Book>> call, @NotNull Response<List<Book>> response) {
                assert response.body() != null;
                Log.e("Main", key);
                List<Book> books = response.body()
                        .stream()
                        .filter(book -> book.getName().toLowerCase().contains(key.toLowerCase()))
                        .collect(Collectors.toList());
                mutableLiveData.postValue(books);
            }

            @Override
            public void onFailure(@NotNull Call<List<Book>> call, @NotNull Throwable t) {
                Log.e("Home Repository", Objects.requireNonNull(t.getMessage()));
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<List<Book>> getBookByType(String idType) {
        MutableLiveData<List<Book>> listMutableLiveData = new MutableLiveData<>();
        bookApi.onFetchBookByType(idType).enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    listMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.e("BookRepository", t.getMessage());
            }
        });
        return listMutableLiveData;
    }

    public LiveData<List<Book>>getAllBookLocal(){
        return bookDAO.getAllBookLocalLive();
    }
}
