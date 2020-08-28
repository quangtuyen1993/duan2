package com.example.bookstory.ui.research;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.bookstory.R;
import com.example.bookstory.dao.BookDAO;
import com.example.bookstory.databinding.ActivitySearchBookBinding;
import com.example.bookstory.ui.base.BaseActivity;
import com.example.bookstory.ui.main.fragment.home.home.HomeViewModel;
import com.example.bookstory.util.BookAdapter;
import com.example.bookstory.vo.Book;

import java.util.List;

import javax.inject.Inject;

public class SearchBookActivity extends BaseActivity {
    private Toolbar toolbar;
    private ActivitySearchBookBinding binding;
    private BookAdapter bookAdapter;
    private SearchView searchView;
    private SearchViewModel vm;
    private LinearLayoutManager layoutManager;
private RecyclerView rvSearchBooks;
    @Inject
    ViewModelProvider.Factory factory;

    void init(){
        rvSearchBooks=findViewById(R.id.rvSearchBooks);
        bookAdapter = new BookAdapter();
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvSearchBooks.setLayoutManager(layoutManager);
        rvSearchBooks.setAdapter(bookAdapter);
        rvSearchBooks.setHasFixedSize(true);
        rvSearchBooks.addOnScrollListener(new RecyclerView.OnScrollListener(){

        });
    }
    private void resetRecyclerview(List<Book>list){
        bookAdapter.setBooks(list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_book);
        vm= new ViewModelProvider(this,factory).get(SearchViewModel.class);
        init();
        vm.listSearch.observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {
                resetRecyclerview(books);
            }
        });
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_appbar);
        toolbar.setTitle("Search Books");

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
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                 vm.search.setValue(query);
            return  true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;

    }

}