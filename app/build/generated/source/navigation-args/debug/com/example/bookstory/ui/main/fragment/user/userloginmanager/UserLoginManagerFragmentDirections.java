package com.example.bookstory.ui.main.fragment.user.userloginmanager;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.bookstory.R;

public class UserLoginManagerFragmentDirections {
  private UserLoginManagerFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionUserLoginManagerFragmentToUserManagerFragment2() {
    return new ActionOnlyNavDirections(R.id.action_userLoginManagerFragment_to_userManagerFragment2);
  }

  @NonNull
  public static NavDirections actionUserLoginManagerFragmentToRegisterFragment2() {
    return new ActionOnlyNavDirections(R.id.action_userLoginManagerFragment_to_registerFragment2);
  }
}
