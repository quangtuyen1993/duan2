package com.example.bookstory.vo;

import android.app.Application;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class UserLocalLogin {
    private static final String SP_NAME = "UserDetail";
    private SharedPreferences userLocal;

    @Inject
    public UserLocalLogin(Application context) {
        userLocal = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUser(User user) {
        SharedPreferences.Editor editor = userLocal.edit();
        editor.putString("id", user.getId());
        editor.putString("email", user.getEmail());
        editor.putString("password", user.getPassword());
        editor.putString("fullName", user.getFullName());
        editor.apply();
        setIsSignIn(true);
    }

    private void setIsSignIn(boolean signIn) {
        SharedPreferences.Editor spe = userLocal.edit();
        spe.putBoolean("loggerIn", signIn);
        spe.apply();
    }

    public boolean isSignIn() {
        return userLocal.getBoolean("loggerIn", false);
    }

    public void signOut() {
        SharedPreferences.Editor editor = userLocal.edit();
        editor.clear();
        editor.apply();
        setIsSignIn(false);

    }

    public User userLoggerInUser() {
        String email = userLocal.getString("email", "");
        String password = userLocal.getString("password", "");
        String id = userLocal.getString("id", "");
        String fullName = userLocal.getString("fullName", "");
        return new User(id, email, password, fullName);
    }
}
