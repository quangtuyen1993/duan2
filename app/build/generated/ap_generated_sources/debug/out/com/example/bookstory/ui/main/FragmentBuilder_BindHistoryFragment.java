package com.example.bookstory.ui.main;

import com.example.bookstory.di.annnotations.FragmentScope;
import com.example.bookstory.ui.main.fragment.library.HistoryLibraryFragment;
import com.example.bookstory.ui.main.fragment.library.HistoryModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = FragmentBuilder_BindHistoryFragment.HistoryLibraryFragmentSubcomponent.class
)
public abstract class FragmentBuilder_BindHistoryFragment {
  private FragmentBuilder_BindHistoryFragment() {}

  @Binds
  @IntoMap
  @ClassKey(HistoryLibraryFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      HistoryLibraryFragmentSubcomponent.Factory builder);

  @Subcomponent(modules = HistoryModule.class)
  @FragmentScope
  public interface HistoryLibraryFragmentSubcomponent
      extends AndroidInjector<HistoryLibraryFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<HistoryLibraryFragment> {}
  }
}
