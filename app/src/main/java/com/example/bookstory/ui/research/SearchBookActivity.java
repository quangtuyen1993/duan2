package com.example.bookstory.ui.research;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.bookstory.R;
import com.example.bookstory.dao.BookDAO;
import com.example.bookstory.databinding.ActivitySearchBookBinding;
import com.example.bookstory.ui.main.fragment.home.home.HomeViewModel;
import com.example.bookstory.util.BookAdapter;

import javax.inject.Inject;

public class SearchBookActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ActivitySearchBookBinding binding;
    private BookAdapter bookAdapter;
    private SearchView searchView;
    private HomeViewModel vm;
    private LinearLayoutManager layoutManager;
    @Inject
    ViewModelProvider.Factory factory;
    @Inject
    BookDAO bookDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_book);
        binding = ActivitySearchBookBinding.inflate(getLayoutInflater());
        binding.getRoot();
        binding.setLifecycleOwner(this);
        binding.setHomeViewModel(vm);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_appbar);
        toolbar.setTitle("Search Books");
    }

    private void setUpRecyclerView(){
        bookAdapter = new BookAdapter();
        layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        binding.rvSearchBooks.setLayoutManager(layoutManager);
        binding.rvSearchBooks.setAdapter(bookAdapter);
        binding.rvSearchBooks.setHasFixedSize(true);
        binding.rvSearchBooks.addOnScrollListener(new RecyclerView.OnScrollListener() {
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        MenuItem searchViewItem = menu.findItem(R.id.menu_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        SearchView.SearchAutoComplete searchAutoComplete
                = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        searchAutoComplete.setHintTextColor(getResources().getColor(android.R.color.background_dark));
        searchAutoComplete.setTextColor(getResources().getColor(android.R.color.background_dark));
        ImageView searchIcon = searchView.findViewById(androidx.appcompat.R.id.search_button);
        searchIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_search_24));
        return true;

    }

}