package com.example.bookstory;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.bookstory.databinding.ActivityBookTitleBindingImpl;
import com.example.bookstory.databinding.ActivityComicBindingImpl;
import com.example.bookstory.databinding.ActivityReadBookBindingImpl;
import com.example.bookstory.databinding.ActivitySearchBookBindingImpl;
import com.example.bookstory.databinding.FragmentBookTitleBindingImpl;
import com.example.bookstory.databinding.FragmentHomeBindingImpl;
import com.example.bookstory.databinding.FragmentRegisterBindingImpl;
import com.example.bookstory.databinding.FragmentUserManagerBindingImpl;
import com.example.bookstory.databinding.ItemBookBindingImpl;
import com.example.bookstory.databinding.ItemBookHistoryBindingImpl;
import com.example.bookstory.databinding.ItemBookTypeBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYBOOKTITLE = 1;

  private static final int LAYOUT_ACTIVITYCOMIC = 2;

  private static final int LAYOUT_ACTIVITYREADBOOK = 3;

  private static final int LAYOUT_ACTIVITYSEARCHBOOK = 4;

  private static final int LAYOUT_FRAGMENTBOOKTITLE = 5;

  private static final int LAYOUT_FRAGMENTHOME = 6;

  private static final int LAYOUT_FRAGMENTREGISTER = 7;

  private static final int LAYOUT_FRAGMENTUSERMANAGER = 8;

  private static final int LAYOUT_ITEMBOOK = 9;

  private static final int LAYOUT_ITEMBOOKHISTORY = 10;

  private static final int LAYOUT_ITEMBOOKTYPE = 11;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(11);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.bookstory.R.layout.activity_book_title, LAYOUT_ACTIVITYBOOKTITLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.bookstory.R.layout.activity_comic, LAYOUT_ACTIVITYCOMIC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.bookstory.R.layout.activity_read_book, LAYOUT_ACTIVITYREADBOOK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.bookstory.R.layout.activity_search_book, LAYOUT_ACTIVITYSEARCHBOOK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.bookstory.R.layout.fragment_book_title, LAYOUT_FRAGMENTBOOKTITLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.bookstory.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.bookstory.R.layout.fragment_register, LAYOUT_FRAGMENTREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.bookstory.R.layout.fragment_user_manager, LAYOUT_FRAGMENTUSERMANAGER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.bookstory.R.layout.item_book, LAYOUT_ITEMBOOK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.bookstory.R.layout.item_book_history, LAYOUT_ITEMBOOKHISTORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.bookstory.R.layout.item_book_type, LAYOUT_ITEMBOOKTYPE);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYBOOKTITLE: {
          if ("layout/activity_book_title_0".equals(tag)) {
            return new ActivityBookTitleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_book_title is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCOMIC: {
          if ("layout/activity_comic_0".equals(tag)) {
            return new ActivityComicBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_comic is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYREADBOOK: {
          if ("layout/activity_read_book_0".equals(tag)) {
            return new ActivityReadBookBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_read_book is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSEARCHBOOK: {
          if ("layout/activity_search_book_0".equals(tag)) {
            return new ActivitySearchBookBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_search_book is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTBOOKTITLE: {
          if ("layout/fragment_book_title_0".equals(tag)) {
            return new FragmentBookTitleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_book_title is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREGISTER: {
          if ("layout/fragment_register_0".equals(tag)) {
            return new FragmentRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_register is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTUSERMANAGER: {
          if ("layout/fragment_user_manager_0".equals(tag)) {
            return new FragmentUserManagerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_user_manager is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMBOOK: {
          if ("layout/item_book_0".equals(tag)) {
            return new ItemBookBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_book is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMBOOKHISTORY: {
          if ("layout/item_book_history_0".equals(tag)) {
            return new ItemBookHistoryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_book_history is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMBOOKTYPE: {
          if ("layout/item_book_type_0".equals(tag)) {
            return new ItemBookTypeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_book_type is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(8);

    static {
      sKeys.put(1, "ViewModel");
      sKeys.put(0, "_all");
      sKeys.put(2, "book");
      sKeys.put(3, "bookType");
      sKeys.put(4, "history");
      sKeys.put(5, "homeViewModel");
      sKeys.put(6, "viewholder");
      sKeys.put(7, "viewmodel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(11);

    static {
      sKeys.put("layout/activity_book_title_0", com.example.bookstory.R.layout.activity_book_title);
      sKeys.put("layout/activity_comic_0", com.example.bookstory.R.layout.activity_comic);
      sKeys.put("layout/activity_read_book_0", com.example.bookstory.R.layout.activity_read_book);
      sKeys.put("layout/activity_search_book_0", com.example.bookstory.R.layout.activity_search_book);
      sKeys.put("layout/fragment_book_title_0", com.example.bookstory.R.layout.fragment_book_title);
      sKeys.put("layout/fragment_home_0", com.example.bookstory.R.layout.fragment_home);
      sKeys.put("layout/fragment_register_0", com.example.bookstory.R.layout.fragment_register);
      sKeys.put("layout/fragment_user_manager_0", com.example.bookstory.R.layout.fragment_user_manager);
      sKeys.put("layout/item_book_0", com.example.bookstory.R.layout.item_book);
      sKeys.put("layout/item_book_history_0", com.example.bookstory.R.layout.item_book_history);
      sKeys.put("layout/item_book_type_0", com.example.bookstory.R.layout.item_book_type);
    }
  }
}
