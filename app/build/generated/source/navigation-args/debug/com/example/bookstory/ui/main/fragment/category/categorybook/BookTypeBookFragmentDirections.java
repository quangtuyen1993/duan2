package com.example.bookstory.ui.main.fragment.category.categorybook;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.example.bookstory.R;
import com.example.bookstory.vo.Book;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class BookTypeBookFragmentDirections {
  private BookTypeBookFragmentDirections() {
  }

  @NonNull
  public static ActionCategoryBookFragmentToBookTitleFragment actionCategoryBookFragmentToBookTitleFragment(
      @NonNull Book book) {
    return new ActionCategoryBookFragmentToBookTitleFragment(book);
  }

  public static class ActionCategoryBookFragmentToBookTitleFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionCategoryBookFragmentToBookTitleFragment(@NonNull Book book) {
      if (book == null) {
        throw new IllegalArgumentException("Argument \"book\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("book", book);
    }

    @NonNull
    public ActionCategoryBookFragmentToBookTitleFragment setBook(@NonNull Book book) {
      if (book == null) {
        throw new IllegalArgumentException("Argument \"book\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("book", book);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_categoryBookFragment_to_bookTitleFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Book getBook() {
      return (Book) arguments.get("book");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionCategoryBookFragmentToBookTitleFragment that = (ActionCategoryBookFragmentToBookTitleFragment) object;
      if (arguments.containsKey("book") != that.arguments.containsKey("book")) {
        return false;
      }
      if (getBook() != null ? !getBook().equals(that.getBook()) : that.getBook() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getBook() != null ? getBook().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionCategoryBookFragmentToBookTitleFragment(actionId=" + getActionId() + "){"
          + "book=" + getBook()
          + "}";
    }
  }
}
