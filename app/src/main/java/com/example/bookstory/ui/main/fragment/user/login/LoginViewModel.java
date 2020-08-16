package com.example.bookstory.ui.main.fragment.user.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bookstory.data.response.UserRepository;
import com.example.bookstory.vo.User;

public class LoginViewModel extends ViewModel {


    private UserRepository userRepository;

    public LoginViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    MutableLiveData<String> username = new MutableLiveData<>();
    MutableLiveData<String> password = new MutableLiveData<>();
    MutableLiveData<String> fullName = new MutableLiveData<>();

    public MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

}
