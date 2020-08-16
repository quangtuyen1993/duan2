package com.example.bookstory.ui.main;

import com.example.bookstory.di.annnotations.FragmentScope;
import com.example.bookstory.ui.main.fragment.category.categorybook.BookTypeBookFragment;
import com.example.bookstory.ui.main.fragment.category.categorybook.BookTypeBookModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = FragmentBuilder_BindBookTypeBookFragment.BookTypeBookFragmentSubcomponent.class
)
public abstract class FragmentBuilder_BindBookTypeBookFragment {
  private FragmentBuilder_BindBookTypeBookFragment() {}

  @Binds
  @IntoMap
  @ClassKey(BookTypeBookFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BookTypeBookFragmentSubcomponent.Factory builder);

  @Subcomponent(modules = BookTypeBookModule.class)
  @FragmentScope
  public interface BookTypeBookFragmentSubcomponent extends AndroidInjector<BookTypeBookFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<BookTypeBookFragment> {}
  }
}
