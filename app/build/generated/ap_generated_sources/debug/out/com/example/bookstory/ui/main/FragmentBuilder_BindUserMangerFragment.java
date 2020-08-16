package com.example.bookstory.ui.main;

import com.example.bookstory.di.annnotations.FragmentScope;
import com.example.bookstory.ui.main.fragment.user.usermanager.UserManagerFragment;
import com.example.bookstory.ui.main.fragment.user.usermanager.UserManagerModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = FragmentBuilder_BindUserMangerFragment.UserManagerFragmentSubcomponent.class
)
public abstract class FragmentBuilder_BindUserMangerFragment {
  private FragmentBuilder_BindUserMangerFragment() {}

  @Binds
  @IntoMap
  @ClassKey(UserManagerFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      UserManagerFragmentSubcomponent.Factory builder);

  @Subcomponent(modules = UserManagerModule.class)
  @FragmentScope
  public interface UserManagerFragmentSubcomponent extends AndroidInjector<UserManagerFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<UserManagerFragment> {}
  }
}
