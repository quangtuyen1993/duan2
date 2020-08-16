package com.example.bookstory.ui.booktitle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.bookstory.R;
import com.example.bookstory.databinding.ActivityBookTitleBinding;
import com.example.bookstory.ui.base.BaseActivity;
import com.example.bookstory.vo.Book;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class BookTitleActivity extends BaseActivity {

    @Inject
    ViewModelProvider.Factory factory;

    Toolbar toolbar;

    private Book book;
    private BookTitleViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        AndroidInjection.inject(this);
        Bundle bundle = getIntent().getExtras();

        assert bundle != null;
        book = (Book) bundle.get("book");
        ActivityBookTitleBinding binding = ActivityBookTitleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbar=findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        vm = new ViewModelProvider(this, factory).get(BookTitleViewModel.class);
        vm.setBookLive(book);
        binding.setViewholder(vm);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();


    }
}