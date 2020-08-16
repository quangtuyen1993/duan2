package com.example.bookstory.ui.main.fragment.category.category;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.example.bookstory.R;
import com.example.bookstory.vo.BookType;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class BookTypeFragmentDirections {
  private BookTypeFragmentDirections() {
  }

  @NonNull
  public static ActionCategoryFragmentToCategoryBookFragment actionCategoryFragmentToCategoryBookFragment(
      @NonNull BookType bookType) {
    return new ActionCategoryFragmentToCategoryBookFragment(bookType);
  }

  public static class ActionCategoryFragmentToCategoryBookFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionCategoryFragmentToCategoryBookFragment(@NonNull BookType bookType) {
      if (bookType == null) {
        throw new IllegalArgumentException("Argument \"bookType\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("bookType", bookType);
    }

    @NonNull
    public ActionCategoryFragmentToCategoryBookFragment setBookType(@NonNull BookType bookType) {
      if (bookType == null) {
        throw new IllegalArgumentException("Argument \"bookType\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("bookType", bookType);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_categoryFragment_to_categoryBookFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public BookType getBookType() {
      return (BookType) arguments.get("bookType");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionCategoryFragmentToCategoryBookFragment that = (ActionCategoryFragmentToCategoryBookFragment) object;
      if (arguments.containsKey("bookType") != that.arguments.containsKey("bookType")) {
        return false;
      }
      if (getBookType() != null ? !getBookType().equals(that.getBookType()) : that.getBookType() != null) {
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
      result = 31 * result + (getBookType() != null ? getBookType().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionCategoryFragmentToCategoryBookFragment(actionId=" + getActionId() + "){"
          + "bookType=" + getBookType()
          + "}";
    }
  }
}
