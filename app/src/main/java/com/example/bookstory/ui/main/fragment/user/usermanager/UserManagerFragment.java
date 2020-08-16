package com.example.bookstory.ui.main.fragment.user.usermanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.bookstory.R;
import com.example.bookstory.databinding.FragmentUserManagerBinding;
import com.example.bookstory.ui.base.BaseFragment;
import com.example.bookstory.vo.User;
import com.example.bookstory.vo.UserLocalLogin;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import javax.inject.Inject;


public class UserManagerFragment extends BaseFragment {

    private Button bt_signOut;

    private FragmentUserManagerBinding fragmentUserManagerBinding;

    private GoogleSignInClient googleSignInClient;

    @Inject
    UserLocalLogin userLocalLogin;

    @Inject
    ViewModelProvider.Factory factory;

    private UserManagerViewModel vm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentUserManagerBinding = FragmentUserManagerBinding.inflate(LayoutInflater.from(requireActivity()));
        fragmentUserManagerBinding.setLifecycleOwner(this);
        fragmentUserManagerBinding.executePendingBindings();
        return fragmentUserManagerBinding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vm = new ViewModelProvider(requireActivity(), factory).get(UserManagerViewModel.class);
        bt_signOut = view.findViewById(R.id.bt_signOut);
        bt_signOut.setOnClickListener(this::onSignOut);
        User user = userLocalLogin.userLoggerInUser();
        fragmentUserManagerBinding.setViewmodel(vm);
        vm.user.setValue(user);
        init(view);
    }



    private void init(View view) {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestIdToken(requireActivity().getResources().getString(R.string.ID_CLIENT))
                .build();
        googleSignInClient = GoogleSignIn.getClient((requireActivity()), gso);
    }

    private void onSignOut(View view) {
        LoginManager.getInstance().logOut();
        userLocalLogin.signOut();
        googleSignInClient.signOut().addOnCompleteListener(requireActivity(), task -> {
            NavHostFragment.findNavController(UserManagerFragment.this).navigate(R.id.action_userManagerFragment2_to_userLoginManagerFragment_pop);
        });

    }

    @Override
    protected String setTitle() {
        return "Profile";
    }
}
