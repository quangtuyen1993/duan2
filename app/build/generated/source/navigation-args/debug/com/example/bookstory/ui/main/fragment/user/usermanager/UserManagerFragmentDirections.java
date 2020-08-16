package com.example.bookstory.ui.main.fragment.user.usermanager;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.bookstory.R;

public class UserManagerFragmentDirections {
  private UserManagerFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionUserManagerFragment2ToUserLoginManagerFragmentPop() {
    return new ActionOnlyNavDirections(R.id.action_userManagerFragment2_to_userLoginManagerFragment_pop);
  }
}
