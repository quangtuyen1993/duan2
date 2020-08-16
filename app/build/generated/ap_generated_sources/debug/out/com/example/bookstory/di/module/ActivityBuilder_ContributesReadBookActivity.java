package com.example.bookstory.di.module;

import com.example.bookstory.di.annnotations.ActivityScope;
import com.example.bookstory.ui.readbook.ReadBookActivity;
import com.example.bookstory.ui.readbook.ReadBookModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityBuilder_ContributesReadBookActivity.ReadBookActivitySubcomponent.class
)
public abstract class ActivityBuilder_ContributesReadBookActivity {
  private ActivityBuilder_ContributesReadBookActivity() {}

  @Binds
  @IntoMap
  @ClassKey(ReadBookActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ReadBookActivitySubcomponent.Factory builder);

  @Subcomponent(modules = ReadBookModule.class)
  @ActivityScope
  public interface ReadBookActivitySubcomponent extends AndroidInjector<ReadBookActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ReadBookActivity> {}
  }
}
