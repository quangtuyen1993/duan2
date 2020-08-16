package com.example.bookstory.vo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class BookType implements Parcelable {

    @SerializedName("_id")
    @PrimaryKey
    @NonNull
    private String id;

    @SerializedName("name")
    private String name;

    public BookType(String name) {
        this.name = name;
    }

    public BookType() {
    }

    public BookType(String id, String name) {
        this.id = id;
        this.name = name;
    }

    protected BookType(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    public static final Creator<BookType> CREATOR = new Creator<BookType>() {
        @Override
        public BookType createFromParcel(Parcel in) {
            return new BookType(in);
        }

        @Override
        public BookType[] newArray(int size) {
            return new BookType[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return name;

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
    }
}
