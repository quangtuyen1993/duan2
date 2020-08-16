package com.example.bookstory.di.module;

import com.example.bookstory.di.annnotations.ActivityScope;
import com.example.bookstory.ui.readbooklocal.ReadBookLocalActivity;
import com.example.bookstory.ui.readbooklocal.ReadBookLocalModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityBuilder_ContributesReadBookLocalActivity.ReadBookLocalActivitySubcomponent.class
)
public abstract class ActivityBuilder_ContributesReadBookLocalActivity {
  private ActivityBuilder_ContributesReadBookLocalActivity() {}

  @Binds
  @IntoMap
  @ClassKey(ReadBookLocalActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ReadBookLocalActivitySubcomponent.Factory builder);

  @Subcomponent(modules = ReadBookLocalModule.class)
  @ActivityScope
  public interface ReadBookLocalActivitySubcomponent
      extends AndroidInjector<ReadBookLocalActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ReadBookLocalActivity> {}
  }
}
