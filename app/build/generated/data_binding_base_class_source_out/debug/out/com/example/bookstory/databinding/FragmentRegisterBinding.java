// Generated by data binding compiler. Do not edit!
package com.example.bookstory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.bookstory.R;
import com.example.bookstory.ui.main.fragment.user.register.RegisterViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentRegisterBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout btControl;

  @NonNull
  public final Button btLogin;

  @NonNull
  public final Button btRegister;

  @NonNull
  public final EditText etEmail;

  @NonNull
  public final EditText etName;

  @NonNull
  public final EditText etPass;

  @NonNull
  public final ProgressBar prLoading;

  @NonNull
  public final TextView textView;

  @Bindable
  protected RegisterViewModel mViewModel;

  protected FragmentRegisterBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout btControl, Button btLogin, Button btRegister, EditText etEmail, EditText etName,
      EditText etPass, ProgressBar prLoading, TextView textView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btControl = btControl;
    this.btLogin = btLogin;
    this.btRegister = btRegister;
    this.etEmail = etEmail;
    this.etName = etName;
    this.etPass = etPass;
    this.prLoading = prLoading;
    this.textView = textView;
  }

  public abstract void setViewModel(@Nullable RegisterViewModel ViewModel);

  @Nullable
  public RegisterViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_register, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentRegisterBinding>inflateInternal(inflater, R.layout.fragment_register, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_register, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentRegisterBinding>inflateInternal(inflater, R.layout.fragment_register, null, false, component);
  }

  public static FragmentRegisterBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentRegisterBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentRegisterBinding)bind(component, view, R.layout.fragment_register);
  }
}
