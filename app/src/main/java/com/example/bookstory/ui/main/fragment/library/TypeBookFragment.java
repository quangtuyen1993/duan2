package com.example.bookstory.ui.main.fragment.library;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookstory.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TypeBookFragment extends Fragment {

    public TypeBookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_type_book, container, false);
    }
}
