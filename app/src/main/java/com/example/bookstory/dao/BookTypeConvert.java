package com.example.bookstory.dao;

import androidx.room.TypeConverter;

import com.example.bookstory.vo.Book;
import com.example.bookstory.vo.BookType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class BookTypeConvert {
    @TypeConverter
    public static String storeBookTypeToString(List<BookType> list) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<BookType>>() {
        }.getType();
        String json = gson.toJson(list, type);
        return json;
    }

    @TypeConverter
    public static List<BookType> storeStringToBookType(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<BookType>>() {
        }.getType();
        List<BookType> list = gson.fromJson(json, type);
        return list;
    }
}
