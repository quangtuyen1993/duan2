package com.example.bookstory.data.response;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bookstory.dao.BookDAO;
import com.example.bookstory.dao.BookTypeDAO;
import com.example.bookstory.service.BookTypeApi;
import com.example.bookstory.vo.BookType;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookTypeRepository {
    private BookTypeApi bookTypeApi;
    private BookTypeDAO bookTypeDAO;

    @Inject
    public BookTypeRepository(BookTypeApi bookTypeApi, BookTypeDAO bookTypeDAO) {
        this.bookTypeApi = bookTypeApi;
        this.bookTypeDAO = bookTypeDAO;
    }

    public MutableLiveData<List<BookType>> fetchAllBook() {
        MutableLiveData<List<BookType>> liveData = new MutableLiveData<>();
        bookTypeApi.onFetchBookType().enqueue(new Callback<List<BookType>>() {
            @Override
            public void onResponse(Call<List<BookType>> call, Response<List<BookType>> response) {
                if (response.isSuccessful()) {
                    liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<BookType>> call, Throwable t) {
                Log.e("Mai", t.getMessage());
            }
        });
        return liveData;
    }

    public LiveData<List<BookType>> fetchAllBookLocal() {
        return bookTypeDAO.getBookLocal();
    }

    public void onAsyncLocalBookType(List<BookType> list) {
        AsyncTask.execute(() -> bookTypeDAO.insertListBookType(list));
    }
}
