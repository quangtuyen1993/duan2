package com.example.bookstory.ui.readbook;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.bookstory.R;
import com.example.bookstory.databinding.ActivityReadBookBinding;
import com.example.bookstory.ui.base.BaseActivity;
import com.example.bookstory.vo.Book;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ReadBookActivity extends BaseActivity {

    @Inject
    ViewModelProvider.Factory factory;

    ReadBookViewModel vm;
    Book book;

    Button bt_pre, bt_next;
    TextView content;

    public List<String> listIdChapter = new ArrayList<>();
    public int statePosition;

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityReadBookBinding binding=ActivityReadBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
        vm = new ViewModelProvider(this, factory).get(ReadBookViewModel.class);
        vm.book.setValue(book);
        vm.setChapNumber(1);
        vm.getIsLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    progressBar.setVisibility(View.VISIBLE);
                    content.setText("");
                }
                else progressBar.setVisibility(View.GONE);
            }
        });
        binding.setViewModel(vm);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();
    }

    private void init() {
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        book = bundle.getParcelable("book");
        content = findViewById(R.id.tv_content);
        bt_pre = findViewById(R.id.bt_pre);
        bt_next = findViewById(R.id.bt_next);
        progressBar=findViewById(R.id.pr_loading);
    }
}