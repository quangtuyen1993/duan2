package com.example.bookstory.ui.main.fragment.user.register;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.bookstory.R;

public class RegisterFragmentDirections {
  private RegisterFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionRegisterFragment2ToUserLoginManagerFragment() {
    return new ActionOnlyNavDirections(R.id.action_registerFragment2_to_userLoginManagerFragment);
  }
}
