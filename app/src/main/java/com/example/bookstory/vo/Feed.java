package com.example.bookstory.vo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Feed implements Parcelable {
    @SerializedName("page")
    private int page;

    @SerializedName("limit")
    private double limit;

    @SerializedName("books")
    private List<Book> book;

    public static final Creator<Feed> CREATOR = new Creator<Feed>() {
        @Override
        public Feed createFromParcel(Parcel in) {
            return new Feed(in);
        }

        @Override
        public Feed[] newArray(int size) {
            return new Feed[size];
        }
    };

    public double getLimit() {
        return limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }


    protected Feed(Parcel in) {
        page = in.readInt();
        limit = in.readDouble();
        book = in.readParcelable(Book.class.getClassLoader());
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(page);
        dest.writeDouble(limit);
        dest.writeTypedList(book);
    }
}
