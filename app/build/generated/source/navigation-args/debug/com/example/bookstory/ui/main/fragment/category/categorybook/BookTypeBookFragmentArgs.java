package com.example.bookstory.ui.main.fragment.category.categorybook;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import com.example.bookstory.vo.BookType;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class BookTypeBookFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private BookTypeBookFragmentArgs() {
  }

  private BookTypeBookFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static BookTypeBookFragmentArgs fromBundle(@NonNull Bundle bundle) {
    BookTypeBookFragmentArgs __result = new BookTypeBookFragmentArgs();
    bundle.setClassLoader(BookTypeBookFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("bookType")) {
      BookType bookType;
      if (Parcelable.class.isAssignableFrom(BookType.class) || Serializable.class.isAssignableFrom(BookType.class)) {
        bookType = (BookType) bundle.get("bookType");
      } else {
        throw new UnsupportedOperationException(BookType.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (bookType == null) {
        throw new IllegalArgumentException("Argument \"bookType\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("bookType", bookType);
    } else {
      throw new IllegalArgumentException("Required argument \"bookType\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public BookType getBookType() {
    return (BookType) arguments.get("bookType");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("bookType")) {
      BookType bookType = (BookType) arguments.get("bookType");
      if (Parcelable.class.isAssignableFrom(BookType.class) || bookType == null) {
        __result.putParcelable("bookType", Parcelable.class.cast(bookType));
      } else if (Serializable.class.isAssignableFrom(BookType.class)) {
        __result.putSerializable("bookType", Serializable.class.cast(bookType));
      } else {
        throw new UnsupportedOperationException(BookType.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
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
    BookTypeBookFragmentArgs that = (BookTypeBookFragmentArgs) object;
    if (arguments.containsKey("bookType") != that.arguments.containsKey("bookType")) {
      return false;
    }
    if (getBookType() != null ? !getBookType().equals(that.getBookType()) : that.getBookType() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getBookType() != null ? getBookType().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "BookTypeBookFragmentArgs{"
        + "bookType=" + getBookType()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(BookTypeBookFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull BookType bookType) {
      if (bookType == null) {
        throw new IllegalArgumentException("Argument \"bookType\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("bookType", bookType);
    }

    @NonNull
    public BookTypeBookFragmentArgs build() {
      BookTypeBookFragmentArgs result = new BookTypeBookFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setBookType(@NonNull BookType bookType) {
      if (bookType == null) {
        throw new IllegalArgumentException("Argument \"bookType\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("bookType", bookType);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public BookType getBookType() {
      return (BookType) arguments.get("bookType");
    }
  }
}
