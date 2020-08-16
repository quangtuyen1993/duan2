package com.example.bookstory.ui.readbooklocal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.bookstory.R;
import com.example.bookstory.ui.base.BaseActivity;
import com.example.bookstory.ui.readbook.ReadBookViewModel;
import com.example.bookstory.vo.Chapter;
import com.example.bookstory.vo.History;

import javax.inject.Inject;

public class ReadBookLocalActivity extends BaseActivity {

    @Inject
    ViewModelProvider.Factory factory;
    ReadBookLocalViewModel viewModel;

    Button bt_prev,bt_next;
    TextView tv_content,tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_book_local);
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        History history = bundle.getParcelable("History");
        init();
        viewModel = new ViewModelProvider(this, factory).get(ReadBookLocalViewModel.class);
        viewModel.setHistoryMutableLiveData(history);
        viewModel.getChapterLiveData().observe(this, chapter -> {
           tv_content.setText(chapter.getContent());
           tv_title.setText(chapter.getName());
        });
    }

    private void init() {
        //map
        bt_next=findViewById(R.id.bt_next);
        bt_prev=findViewById(R.id.bt_pre);
        tv_content=findViewById(R.id.tv_content);
        tv_title=findViewById(R.id.tv_title);

        bt_next.setOnClickListener(v->viewModel.onNext());
        bt_prev.setOnClickListener(v->viewModel.onPre());
    }

}
