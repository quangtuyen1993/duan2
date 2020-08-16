package com.example.bookstory.ui.main;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.bookstory.R;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidInjection.inject(this);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setUpNavigation();
    }

    public void setUpNavigation() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        NavigationUI.setupWithNavController(bottomNavigationView,
                navHostFragment.getNavController());
    }
}
