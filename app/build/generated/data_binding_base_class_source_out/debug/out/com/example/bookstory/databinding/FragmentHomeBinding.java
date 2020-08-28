// Generated by data binding compiler. Do not edit!
package com.example.bookstory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bookstory.R;
import com.example.bookstory.ui.main.fragment.home.home.HomeViewModel;
import com.synnapps.carouselview.CarouselView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentHomeBinding extends ViewDataBinding {
  @NonNull
  public final CarouselView carouselView;

  @NonNull
  public final ImageView ivLogo;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final RelativeLayout rlHeader;

  @NonNull
  public final RecyclerView rv;

  @NonNull
  public final RecyclerView rvTopViews;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final TextView tvTitleTopBooks;

  @Bindable
  protected HomeViewModel mHomeViewModel;

  protected FragmentHomeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CarouselView carouselView, ImageView ivLogo, ProgressBar progressBar, RelativeLayout rlHeader,
      RecyclerView rv, RecyclerView rvTopViews, TextView tvTitle, TextView tvTitleTopBooks) {
    super(_bindingComponent, _root, _localFieldCount);
    this.carouselView = carouselView;
    this.ivLogo = ivLogo;
    this.progressBar = progressBar;
    this.rlHeader = rlHeader;
    this.rv = rv;
    this.rvTopViews = rvTopViews;
    this.tvTitle = tvTitle;
    this.tvTitleTopBooks = tvTitleTopBooks;
  }

  public abstract void setHomeViewModel(@Nullable HomeViewModel homeViewModel);

  @Nullable
  public HomeViewModel getHomeViewModel() {
    return mHomeViewModel;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_home, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentHomeBinding>inflateInternal(inflater, R.layout.fragment_home, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_home, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentHomeBinding>inflateInternal(inflater, R.layout.fragment_home, null, false, component);
  }

  public static FragmentHomeBinding bind(@NonNull View view) {
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
  public static FragmentHomeBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentHomeBinding)bind(component, view, R.layout.fragment_home);
  }
}
