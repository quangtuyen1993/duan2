package com.example.bookstory.ui.main;

import com.example.bookstory.di.annnotations.FragmentScope;
import com.example.bookstory.ui.main.fragment.home.title.BookTitleFragment;
import com.example.bookstory.ui.main.fragment.home.title.BookTitleModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = FragmentBuilder_BindBookTitleFragment.BookTitleFragmentSubcomponent.class)
public abstract class FragmentBuilder_BindBookTitleFragment {
  private FragmentBuilder_BindBookTitleFragment() {}

  @Binds
  @IntoMap
  @ClassKey(BookTitleFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BookTitleFragmentSubcomponent.Factory builder);

  @Subcomponent(modules = BookTitleModule.class)
  @FragmentScope
  public interface BookTitleFragmentSubcomponent extends AndroidInjector<BookTitleFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<BookTitleFragment> {}
  }
}
