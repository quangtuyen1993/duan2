package com.example.bookstory.vo;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.bookstory.dao.BookConvert;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

@Entity
public class History implements Parcelable {
    @PrimaryKey
    @SerializedName("_id")
    @NotNull
    private String id;
    @SerializedName("idUser")
    private String idUser;
    @SerializedName("book")

    @TypeConverters(BookConvert.class)
    private Book book;

    @SerializedName("chapterNumber")
    private int chapterState;

    protected History(Parcel in) {
        id = in.readString();
        idUser = in.readString();
        book = in.readParcelable(Book.class.getClassLoader());
        chapterState = in.readInt();
    }

    public History(@NotNull String id, String idUser, Book book, int chapterState) {
        this.id = id;
        this.idUser = idUser;
        this.book = book;
        this.chapterState = chapterState;
    }

    public static final Creator<History> CREATOR = new Creator<History>() {
        @Override
        public History createFromParcel(Parcel in) {
            return new History(in);
        }

        @Override
        public History[] newArray(int size) {
            return new History[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getChapterState() {
        return chapterState;
    }

    public void setChapterState(int chapterState) {
        this.chapterState = chapterState;
    }
    @BindingAdapter({"imgUrl", "error"})
    public static void setImageView(ImageView imageView, String url, Drawable error) {
        Picasso.get().load(url).error(error).resize(400, 400).centerCrop().into(imageView);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(idUser);
        dest.writeParcelable(book, flags);
        dest.writeInt(chapterState);
    }
}
