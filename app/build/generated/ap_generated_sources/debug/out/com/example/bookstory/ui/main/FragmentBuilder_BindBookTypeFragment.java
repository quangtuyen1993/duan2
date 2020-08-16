package com.example.bookstory.ui.main;

import com.example.bookstory.di.annnotations.FragmentScope;
import com.example.bookstory.ui.main.fragment.category.category.BookTypeFragment;
import com.example.bookstory.ui.main.fragment.category.category.BookTypeModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = FragmentBuilder_BindBookTypeFragment.BookTypeFragmentSubcomponent.class)
public abstract class FragmentBuilder_BindBookTypeFragment {
  private FragmentBuilder_BindBookTypeFragment() {}

  @Binds
  @IntoMap
  @ClassKey(BookTypeFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BookTypeFragmentSubcomponent.Factory builder);

  @Subcomponent(modules = BookTypeModule.class)
  @FragmentScope
  public interface BookTypeFragmentSubcomponent extends AndroidInjector<BookTypeFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<BookTypeFragment> {}
  }
}
