package com.example.bookstory.ui.main.fragment.user.userloginmanager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.example.bookstory.R;
import com.example.bookstory.ui.base.BaseFragment;
import com.example.bookstory.vo.User;
import com.example.bookstory.vo.UserLocalLogin;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserLoginManagerFragment extends BaseFragment {

    private static int SIGN_IN_GOOGLE = 121;
    private static int SIGN_IN_FACEBOOK = 123;

    //button
    private SignInButton bt_loginGoogle;
    private LoginButton bt_loginFacebook;
    private Button bt_loginEmail;
    private Button bt_register;

    private EditText et_password;
    private EditText et_email;

    private TextView tv_err;

    private GoogleSignInClient googleSignInClient;
    private CallbackManager callbackManager;

    private String idToken;

    @Inject
    UserLocalLogin userLocalLogin;


    @Inject
    ViewModelProvider.Factory factory;
    private UserLoginManagerViewModel vm;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_login_manager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm = new ViewModelProvider(this, factory).get(UserLoginManagerViewModel.class);
        init(requireView());
        vm.error.observe(getViewLifecycleOwner(), s -> tv_err.setText(s));

        if (userLocalLogin.isSignIn()) {
            onChangeScreen();
        } else {
            vm.userOAuth.observe(getViewLifecycleOwner(), this::storeUser);
            vm.userEmail.observe(getViewLifecycleOwner(), this::storeUser);
            vm.userFacebook.observe(getViewLifecycleOwner(),this::storeUser);
        }
    }


    private void init(@NotNull View view) {
        et_email = view.findViewById(R.id.et_email);
        et_password = view.findViewById(R.id.et_password);
        tv_err = view.findViewById(R.id.tv_err);

        bt_loginGoogle = view.findViewById(R.id.bt_signInGoogle);
        bt_loginEmail = view.findViewById(R.id.bt_loginEmail);
        bt_loginFacebook = view.findViewById(R.id.login_button);
        bt_register = view.findViewById(R.id.bt_register);

        bt_loginFacebook.setFragment(this);

        callbackManager = CallbackManager.Factory.create();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(requireActivity().getResources().getString(R.string.ID_CLIENT))
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso);
        checkSignIn();

        bt_loginEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signEmailAndPassword(v);
                checkLogin();
            }
        });
        bt_loginGoogle.setOnClickListener(this::signGoogle);
        bt_loginFacebook.setOnClickListener(this::signFacebook);
        bt_register.setOnClickListener(this::changeRegister);
        bt_loginFacebook.setReadPermissions(Arrays.asList("public_profile", "email", "user_birthday", "user_friends"));

    }


    private void signFacebook(View view) {
        bt_loginFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handlerProfile(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Log.e("Main", Objects.requireNonNull(error.getMessage()));
            }
        });
    }

    private void handlerProfile(AccessToken accessToken) {
        GraphRequest graphRequest = new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                accessToken.getUserId(),
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        try {
                            String id = accessToken.getUserId();
                            String email = response.getJSONObject().getString("email");
                            String name = response.getJSONObject().getString("name");
                            vm.onLoginFacebook(id, email, name);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }
        );
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email,gender,birthday");
        graphRequest.setParameters(parameters);
        graphRequest.executeAsync();
    }

    private void checkSignIn() {
        googleSignInClient.silentSignIn().addOnCompleteListener(requireActivity(), this::handleSignInResult);
    }

    private void signGoogle(View view) {
        Intent intent = googleSignInClient.getSignInIntent();
        startActivityForResult(intent, SIGN_IN_GOOGLE);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_IN_GOOGLE) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }

    }

    //login oAuthor
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            assert account != null;
            idToken = account.getIdToken();
            vm.onLoginUserLoginOAuth(idToken);
        } catch (ApiException e) {
            Log.e("Main", Objects.requireNonNull(e.getMessage()));
        }
    }

    //login email password
    private void signEmailAndPassword(View view) {
        vm.onLogin(et_email.getText().toString(), et_password.getText().toString());
    }

    //change screen
    private void onChangeScreen() {
        NavDirections action = UserLoginManagerFragmentDirections.actionUserLoginManagerFragmentToUserManagerFragment2();
        NavHostFragment.findNavController(UserLoginManagerFragment.this).navigate(action);
    }

    private void changeRegister(View view) {
        NavDirections action = UserLoginManagerFragmentDirections.actionUserLoginManagerFragmentToRegisterFragment2();
        NavHostFragment.findNavController(UserLoginManagerFragment.this).navigate(action);
    }

    private void storeUser(User user) {
        Log.e("main",user+"");
        if (user != null) {
            userLocalLogin.storeUser(user);
            onChangeScreen();
        }
    }

    public void checkLogin(){
        try {
            String email = et_email.getText().toString();
            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                    if (email.matches(emailPattern) && email.length() > 0) {
                        Toast.makeText(getContext(), "valid email address", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                    }
        } catch (Exception ex){

        }
    }

    @Override
    protected String setTitle() {
        return "Authentication";
    }

}
