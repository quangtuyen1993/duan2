package com.example.bookstory.ui.main;

import com.example.bookstory.di.annnotations.FragmentScope;
import com.example.bookstory.ui.main.fragment.home.readBook.ReadBookFragment;
import com.example.bookstory.ui.main.fragment.home.readBook.ReadBookModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = FragmentBuilder_BindReadBookFragment.ReadBookFragmentSubcomponent.class)
public abstract class FragmentBuilder_BindReadBookFragment {
  private FragmentBuilder_BindReadBookFragment() {}

  @Binds
  @IntoMap
  @ClassKey(ReadBookFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ReadBookFragmentSubcomponent.Factory builder);

  @Subcomponent(modules = ReadBookModule.class)
  @FragmentScope
  public interface ReadBookFragmentSubcomponent extends AndroidInjector<ReadBookFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ReadBookFragment> {}
  }
}
