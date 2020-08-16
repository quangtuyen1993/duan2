package com.example.bookstory.ui.comic;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;

import com.example.bookstory.R;
import com.example.bookstory.databinding.ActivityComicBinding;
import com.example.bookstory.ui.base.BaseActivity;
import com.example.bookstory.ui.comic.adapter.ComicAdapter;
import com.example.bookstory.util.LoadBitmap.LoadBitmap;
import com.example.bookstory.vo.Book;
import com.example.bookstory.vo.ComicChapter;
import com.example.bookstory.vo.ContentComic;
import com.example.bookstory.vo.LoadingImg;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ComicActivity extends BaseActivity implements ComicAdapter.CallbackBitmap {

    @Inject
    ViewModelProvider.Factory factory;
    ComicViewModel viewModel;
    Book book;
    ComicAdapter comicAdapter;
    ActivityComicBinding binding;
    RecyclerView rv;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityComicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this, factory).get(ComicViewModel.class);
        getBook();
        viewModel.book.setValue(book);

        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
        binding.executePendingBindings();

        init();

        viewModel.comicChapter.observe(this, comicChapter -> {
            List<LoadingImg> list = new ArrayList<>();
            comicChapter.getContent().forEach(s -> {
                LoadingImg loadingImg = new LoadingImg(s, comicChapter.getId());
                list.add(loadingImg);
            });

            layoutManager.scrollToPosition(0);
            layoutManager.setSmoothScrollbarEnabled(false);
            comicAdapter.setUrls(list);
            comicAdapter.setItemVisible(0);
        });
        rv.addOnScrollListener(
                new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                        int index = layoutManager.findLastVisibleItemPosition();
                        comicAdapter.setItemVisible(index);
                    }
                });


    }

    private void init() {
        comicAdapter = new ComicAdapter();
        comicAdapter.setCallbackBitmap(this);
        rv = findViewById(R.id.rv_img);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(comicAdapter);
    }


    private void getBook() {
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        book = bundle.getParcelable("book");
    }

    @Override
    public void getBitMap(Bitmap bitmap, String idChapter, int position) {
        AsyncTask.execute(()->{
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream .toByteArray();
            viewModel.insertContentComic(new ContentComic(idChapter,byteArray,position));
        });

    }
}
