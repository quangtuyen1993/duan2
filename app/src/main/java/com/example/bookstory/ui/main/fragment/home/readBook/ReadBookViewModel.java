package com.example.bookstory.ui.main.fragment.home.readBook;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.bookstory.data.response.ChapterRepository;
import com.example.bookstory.vo.Chapter;

import java.util.List;

import javax.inject.Inject;

public class ReadBookViewModel extends ViewModel {


    private ChapterRepository chapterRepository;
    MutableLiveData<String> idBook = new MutableLiveData<>();
    LiveData<List<Chapter>> chapters = Transformations.switchMap(idBook, id -> chapterRepository.fetchAllChapterByBook(id));

    @Inject
    ReadBookViewModel(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }


}
