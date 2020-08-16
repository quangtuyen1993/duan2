package com.example.bookstory.ui.main.fragment.user.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.example.bookstory.R;
import com.example.bookstory.databinding.FragmentRegisterBinding;
import com.example.bookstory.ui.base.BaseFragment;
import com.example.bookstory.ui.main.fragment.user.userloginmanager.UserLoginManagerFragment;
import com.example.bookstory.ui.main.fragment.user.userloginmanager.UserLoginManagerFragmentDirections;

import javax.inject.Inject;


public class RegisterFragment extends BaseFragment {


    public RegisterFragment() {

    }

    FragmentRegisterBinding binding;

    @Inject
    ViewModelProvider.Factory factory;

    private RegisterViewModel vm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vm = new ViewModelProvider(this, factory).get(RegisterViewModel.class);
        binding = FragmentRegisterBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.setViewModel(vm);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();


        vm.isLoading.observe(getViewLifecycleOwner(), aBoolean -> {
            if (vm.isLoading.getValue()) {
                binding.prLoading.setVisibility(View.VISIBLE);
            } else {
                binding.prLoading.setVisibility(View.GONE);
            }
        });
        vm.isSuccess.observe(getViewLifecycleOwner(), isSuccess ->
        {
            if (isSuccess)
                changeScreen();
        });
        init();
    }

    private void init() {
        binding.btRegister.setOnClickListener(v -> vm.onRegister());
        binding.btLogin.setOnClickListener(v -> changeScreen());
    }

    private void changeScreen() {
        NavDirections action = RegisterFragmentDirections.actionRegisterFragment2ToUserLoginManagerFragment();
        NavHostFragment.findNavController(RegisterFragment.this).navigate(action);
    }


    @Override
    protected String setTitle() {
        return "Register";
    }
}
