package com.example.bookstory.ui.main.fragment.library;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.bookstory.R;
import com.example.bookstory.ui.base.BaseFragment;
import com.example.bookstory.ui.main.fragment.library.adapter.BookHistoryAdapter;
import com.example.bookstory.ui.readbooklocal.ReadBookLocalActivity;
import com.example.bookstory.util.ItemOnClick;
import com.example.bookstory.vo.History;
import com.example.bookstory.vo.User;
import com.example.bookstory.vo.UserLocalLogin;

import java.util.List;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;


public class HistoryLibraryFragment extends BaseFragment implements ItemOnClick<History> {

    @Inject
    ViewModelProvider.Factory factory;

    HistoryViewModel viewModel;

    @Inject
    UserLocalLogin userLocalLogin;

    private RecyclerView rv_history;
    private LinearLayoutManager layoutManager;
    private BookHistoryAdapter bookHistoryAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(this, factory).get(HistoryViewModel.class);
        User user = userLocalLogin.userLoggerInUser();
        viewModel.setUser(user);
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_history = view.findViewById(R.id.rv_bookHistory);
        bookHistoryAdapter = new BookHistoryAdapter();
        layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        rv_history.setLayoutManager(layoutManager);
        rv_history.setAdapter(bookHistoryAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel.fetchListNetwork();
        viewModel.getHistoryLocal().observe(getViewLifecycleOwner(), histories -> {
            bookHistoryAdapter.setList(histories);
        });
        bookHistoryAdapter.setItemOnClick(this);
    }

    @Override
    protected String setTitle() {
        return "Library";
    }

    @Override
    public void onClick(History history) {
        Intent intent=new Intent(requireActivity(), ReadBookLocalActivity.class);
        Bundle bundle=new Bundle();
        bundle.putParcelable("History",history);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
