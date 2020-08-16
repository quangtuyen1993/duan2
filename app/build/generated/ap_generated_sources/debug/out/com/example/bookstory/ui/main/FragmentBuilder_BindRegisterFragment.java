package com.example.bookstory.ui.main;

import com.example.bookstory.di.annnotations.FragmentScope;
import com.example.bookstory.ui.main.fragment.user.register.RegisterFragment;
import com.example.bookstory.ui.main.fragment.user.register.RegisterModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = FragmentBuilder_BindRegisterFragment.RegisterFragmentSubcomponent.class)
public abstract class FragmentBuilder_BindRegisterFragment {
  private FragmentBuilder_BindRegisterFragment() {}

  @Binds
  @IntoMap
  @ClassKey(RegisterFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      RegisterFragmentSubcomponent.Factory builder);

  @Subcomponent(modules = RegisterModule.class)
  @FragmentScope
  public interface RegisterFragmentSubcomponent extends AndroidInjector<RegisterFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<RegisterFragment> {}
  }
}
