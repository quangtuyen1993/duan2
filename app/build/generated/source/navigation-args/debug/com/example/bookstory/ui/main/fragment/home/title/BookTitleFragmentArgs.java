package com.example.bookstory.ui.main.fragment.home.title;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import com.example.bookstory.vo.Book;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class BookTitleFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private BookTitleFragmentArgs() {
  }

  private BookTitleFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static BookTitleFragmentArgs fromBundle(@NonNull Bundle bundle) {
    BookTitleFragmentArgs __result = new BookTitleFragmentArgs();
    bundle.setClassLoader(BookTitleFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("book")) {
      Book book;
      if (Parcelable.class.isAssignableFrom(Book.class) || Serializable.class.isAssignableFrom(Book.class)) {
        book = (Book) bundle.get("book");
      } else {
        throw new UnsupportedOperationException(Book.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (book == null) {
        throw new IllegalArgumentException("Argument \"book\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("book", book);
    } else {
      throw new IllegalArgumentException("Required argument \"book\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Book getBook() {
    return (Book) arguments.get("book");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("book")) {
      Book book = (Book) arguments.get("book");
      if (Parcelable.class.isAssignableFrom(Book.class) || book == null) {
        __result.putParcelable("book", Parcelable.class.cast(book));
      } else if (Serializable.class.isAssignableFrom(Book.class)) {
        __result.putSerializable("book", Serializable.class.cast(book));
      } else {
        throw new UnsupportedOperationException(Book.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    BookTitleFragmentArgs that = (BookTitleFragmentArgs) object;
    if (arguments.containsKey("book") != that.arguments.containsKey("book")) {
      return false;
    }
    if (getBook() != null ? !getBook().equals(that.getBook()) : that.getBook() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getBook() != null ? getBook().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "BookTitleFragmentArgs{"
        + "book=" + getBook()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(BookTitleFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull Book book) {
      if (book == null) {
        throw new IllegalArgumentException("Argument \"book\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("book", book);
    }

    @NonNull
    public BookTitleFragmentArgs build() {
      BookTitleFragmentArgs result = new BookTitleFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setBook(@NonNull Book book) {
      if (book == null) {
        throw new IllegalArgumentException("Argument \"book\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("book", book);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Book getBook() {
      return (Book) arguments.get("book");
    }
  }
}
