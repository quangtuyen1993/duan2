package com.example.bookstory.di.module;

import com.example.bookstory.di.annnotations.ActivityScope;
import com.example.bookstory.ui.comic.ComicActivity;
import com.example.bookstory.ui.comic.ComicModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = ActivityBuilder_ContributesComicActivity.ComicActivitySubcomponent.class)
public abstract class ActivityBuilder_ContributesComicActivity {
  private ActivityBuilder_ContributesComicActivity() {}

  @Binds
  @IntoMap
  @ClassKey(ComicActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      ComicActivitySubcomponent.Factory builder);

  @Subcomponent(modules = ComicModule.class)
  @ActivityScope
  public interface ComicActivitySubcomponent extends AndroidInjector<ComicActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ComicActivity> {}
  }
}
