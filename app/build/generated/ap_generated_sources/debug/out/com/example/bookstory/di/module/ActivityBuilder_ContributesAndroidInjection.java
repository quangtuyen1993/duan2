package com.example.bookstory.di.module;

import com.example.bookstory.di.annnotations.ActivityScope;
import com.example.bookstory.ui.main.FragmentBuilder;
import com.example.bookstory.ui.main.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = ActivityBuilder_ContributesAndroidInjection.MainActivitySubcomponent.class)
public abstract class ActivityBuilder_ContributesAndroidInjection {
  private ActivityBuilder_ContributesAndroidInjection() {}

  @Binds
  @IntoMap
  @ClassKey(MainActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MainActivitySubcomponent.Factory builder);

  @Subcomponent(modules = FragmentBuilder.class)
  @ActivityScope
  public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainActivity> {}
  }
}
