package com.example.bookstory.vo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import retrofit2.internal.EverythingIsNonNull;

@Entity
public class Chapter implements Parcelable {

    @PrimaryKey
    @SerializedName("_id")
    @NotNull
    private String id;

    @SerializedName("date")
    private String date;

    @SerializedName("name")
    private String name;

    @SerializedName("content")
    private String content;


    @SerializedName("book")
    private String idBook;

    @SerializedName("chapNumber")
    private int chapterNumber;


    protected Chapter(Parcel in) {
        id = Objects.requireNonNull(in.readString());
        date = in.readString();
        name = in.readString();
        content = in.readString();
        idBook = in.readString();
        chapterNumber = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(date);
        dest.writeString(name);
        dest.writeString(content);
        dest.writeString(idBook);
        dest.writeInt(chapterNumber);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Chapter> CREATOR = new Creator<Chapter>() {
        @Override
        public Chapter createFromParcel(Parcel in) {
            return new Chapter(in);
        }

        @Override
        public Chapter[] newArray(int size) {
            return new Chapter[size];
        }
    };

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public Chapter(@NotNull String id, String date, String name, String content, String idBook, int chapterNumber) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.content = content;
        this.idBook = idBook;
        this.chapterNumber = chapterNumber;
    }
}

