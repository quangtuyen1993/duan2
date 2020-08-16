package com.example.bookstory.ui.main;

import com.example.bookstory.di.annnotations.FragmentScope;
import com.example.bookstory.ui.main.fragment.user.userloginmanager.UserLoginManagerFragment;
import com.example.bookstory.ui.main.fragment.user.userloginmanager.UserLoginManagerModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = FragmentBuilder_BindUserManagerFragment.UserLoginManagerFragmentSubcomponent.class
)
public abstract class FragmentBuilder_BindUserManagerFragment {
  private FragmentBuilder_BindUserManagerFragment() {}

  @Binds
  @IntoMap
  @ClassKey(UserLoginManagerFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      UserLoginManagerFragmentSubcomponent.Factory builder);

  @Subcomponent(modules = UserLoginManagerModule.class)
  @FragmentScope
  public interface UserLoginManagerFragmentSubcomponent
      extends AndroidInjector<UserLoginManagerFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<UserLoginManagerFragment> {}
  }
}
