package com.example.bookstory.ui.main.fragment.library;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.bookstory.R;

public class HistoryLibraryFragmentDirections {
  private HistoryLibraryFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionLibaryFragmentToTypeBookFragment() {
    return new ActionOnlyNavDirections(R.id.action_libaryFragment_to_typeBookFragment);
  }
}
