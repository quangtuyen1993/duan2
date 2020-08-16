package com.example.bookstory.ui.base;

import android.content.Context;

import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

public abstract class BaseFragment extends DaggerFragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        requireActivity().setTitle(setTitle());
    }

    protected abstract String setTitle();
}
