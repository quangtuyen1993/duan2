package com.example.bookstory.ui.main.fragment.user.usermanager;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bookstory.data.response.UserRepository;
import com.example.bookstory.vo.User;
import com.example.bookstory.vo.UserLocalLogin;

import javax.inject.Inject;

public class UserManagerViewModel extends ViewModel {
    private UserRepository userRepository;

    @Inject
    public UserManagerViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public MutableLiveData<User> user = new MutableLiveData<User>();
    @Inject
    UserLocalLogin userLocalLogin;
    private MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> getEmail() {
        email.setValue(userLocalLogin.userLoggerInUser().getEmail());
        return email;
    }
    private MutableLiveData<String> fullName = new MutableLiveData<>();
    public MutableLiveData<String> getFullName() {
        fullName.setValue(userLocalLogin.userLoggerInUser().getFullName());
        return fullName;
    }
    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
