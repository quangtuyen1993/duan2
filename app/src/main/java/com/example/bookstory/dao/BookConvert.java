package com.example.bookstory.dao;

import androidx.room.TypeConverter;

import com.example.bookstory.vo.Book;
import com.example.bookstory.vo.BookType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class BookConvert {
    @TypeConverter
    public static String storeBookTypeToString(Book book) {
        Gson gson = new Gson();
        Type type = new TypeToken<Book>() {
        }.getType();
        String json = gson.toJson(book, type);
        return json;
    }

    @TypeConverter
    public static Book storeStringToBookType(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Book>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}
