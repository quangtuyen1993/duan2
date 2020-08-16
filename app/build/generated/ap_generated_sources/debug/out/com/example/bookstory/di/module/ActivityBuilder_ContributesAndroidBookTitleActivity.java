package com.example.bookstory.di.module;

import com.example.bookstory.di.annnotations.ActivityScope;
import com.example.bookstory.ui.booktitle.BookTitleActivity;
import com.example.bookstory.ui.booktitle.BookTitleModel;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      ActivityBuilder_ContributesAndroidBookTitleActivity.BookTitleActivitySubcomponent.class
)
public abstract class ActivityBuilder_ContributesAndroidBookTitleActivity {
  private ActivityBuilder_ContributesAndroidBookTitleActivity() {}

  @Binds
  @IntoMap
  @ClassKey(BookTitleActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BookTitleActivitySubcomponent.Factory builder);

  @Subcomponent(modules = BookTitleModel.class)
  @ActivityScope
  public interface BookTitleActivitySubcomponent extends AndroidInjector<BookTitleActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<BookTitleActivity> {}
  }
}
