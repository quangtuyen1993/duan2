package com.example.bookstory.ui.main;

import com.example.bookstory.di.annnotations.FragmentScope;
import com.example.bookstory.ui.main.fragment.home.readBook.viewpager.ReadBookPagerModule;
import com.example.bookstory.ui.main.fragment.home.readBook.viewpager.ReadBookViewPager;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = FragmentBuilder_BindReadBookViewPager.ReadBookViewPagerSubcomponent.class)
public abstract class FragmentBuilder_BindReadBookViewPager {
  private FragmentBuilder_BindReadBookViewPager() {}

  @Binds
  @IntoMap
  @ClassKey(ReadBookViewPager.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ReadBookViewPagerSubcomponent.Factory builder);

  @Subcomponent(modules = ReadBookPagerModule.class)
  @FragmentScope
  public interface ReadBookViewPagerSubcomponent extends AndroidInjector<ReadBookViewPager> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ReadBookViewPager> {}
  }
}
