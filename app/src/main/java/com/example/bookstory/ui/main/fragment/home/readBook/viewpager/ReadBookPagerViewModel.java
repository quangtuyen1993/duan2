package com.example.bookstory.ui.main.fragment.home.readBook.viewpager;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.bookstory.data.response.ChapterRepository;
import com.example.bookstory.vo.Chapter;

import javax.inject.Inject;

public class ReadBookPagerViewModel extends ViewModel {
    private ChapterRepository chapterRepository;
    public MutableLiveData<String> idChapter = new MutableLiveData<>("");
    public LiveData<Chapter> chapter =
            Transformations.switchMap(idChapter, id -> chapterRepository.getChapterById(id));

    @Inject
    public ReadBookPagerViewModel(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }
}
