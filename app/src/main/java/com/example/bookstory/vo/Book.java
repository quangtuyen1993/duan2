package com.example.bookstory.vo;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.bookstory.dao.BookTypeConvert;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;


@Keep
@Entity
public class Book implements Parcelable, Comparable<Book> {


    @SerializedName("_id")
    @PrimaryKey
    @NonNull
    private String id;

    @SerializedName("bookTypes")
    @TypeConverters(BookTypeConvert.class)
    private List<BookType> bookType;

    @SerializedName("name")
    private String name;

    @SerializedName("status")
    private String status;

    @SerializedName("translator")
    private String translators;

    @SerializedName("author")
    private String author;

    @SerializedName("chapters")
    private int chapters;

    @SerializedName("description")
    private String des;

    @SerializedName("img")
    private String imgUrl;

    @SerializedName("date")
    private String dateStart;

    @SerializedName("dateUpdate")
    private String dateUpdate;

    @SerializedName("chapterPosition")
    private int chapterPosition;

    @SerializedName("comics")
    private int comics;

    public Book(@NonNull String id, List<BookType> bookType, String name, String status, String translators, String author, int chapters, String des, String imgUrl, String dateStart, String dateUpdate, int chapterPosition, int comics) {
        this.id = id;
        this.bookType = bookType;
        this.name = name;
        this.status = status;
        this.translators = translators;
        this.author = author;
        this.chapters = chapters;
        this.des = des;
        this.imgUrl = imgUrl;
        this.dateStart = dateStart;
        this.dateUpdate = dateUpdate;
        this.chapterPosition = chapterPosition;
        this.comics = comics;
    }

    protected Book(Parcel in) {
        id = in.readString();
        bookType = in.createTypedArrayList(BookType.CREATOR);
        name = in.readString();
        status = in.readString();
        translators = in.readString();
        author = in.readString();
        chapters = in.readInt();
        des = in.readString();
        imgUrl = in.readString();
        dateStart = in.readString();
        dateUpdate = in.readString();
        chapterPosition = in.readInt();
        comics = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public int getComics() {
        return comics;
    }

    public void setComics(int comics) {
        this.comics = comics;
    }



    public static DiffUtil.ItemCallback<Book> getDiffBook() {
        return DIFF_BOOK;
    }

    public static void setDiffBook(DiffUtil.ItemCallback<Book> diffBook) {
        DIFF_BOOK = diffBook;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BookType> getBookType() {
        return bookType;
    }

    public void setBookType(List<BookType> bookType) {
        this.bookType = bookType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTranslators() {
        return translators;
    }

    public void setTranslators(String translators) {
        this.translators = translators;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public int getChapterPosition() {
        return chapterPosition;
    }

    public void setChapterPosition(int chapterPosition) {
        this.chapterPosition = chapterPosition;
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
        dest.writeTypedList(bookType);
        dest.writeString(name);
        dest.writeString(status);
        dest.writeString(translators);
        dest.writeString(author);
        dest.writeInt(chapters);
        dest.writeString(des);
        dest.writeString(imgUrl);
        dest.writeString(dateStart);
        dest.writeString(dateUpdate);
        dest.writeInt(chapterPosition);
        dest.writeInt(comics);
    }


    public static DiffUtil.ItemCallback<Book> DIFF_BOOK = new DiffUtil.ItemCallback<Book>() {
        @Override
        public boolean areItemsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
            return oldItem.id.equals(newItem.id);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
            return oldItem.author.equals(newItem.author);
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return chapters == book.chapters &&
                Objects.equals(id, book.id) &&
                Objects.equals(bookType, book.bookType) &&
                Objects.equals(name, book.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookType, name, status, translators, author, chapters, des, imgUrl, dateStart, dateUpdate);
    }

    @Override
    public int compareTo(Book book) {
        String ISO_8601_24H_FULL_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
        TimeZone UTC;
        UTC = TimeZone.getTimeZone("ICT");
        TimeZone.setDefault(UTC);
        final SimpleDateFormat sdf = new SimpleDateFormat(ISO_8601_24H_FULL_FORMAT);
        sdf.setTimeZone(UTC);
        try {
            Date date = sdf.parse(this.getDateUpdate());

            Date date1 = sdf.parse(book.getDateUpdate());
            assert date != null;
            return date.compareTo(date1);

        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
