package com.example.bookstory.ui.readbooklocal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.bookstory.data.response.ChapterRepository;
import com.example.bookstory.vo.Book;
import com.example.bookstory.vo.Chapter;
import com.example.bookstory.vo.History;

import javax.inject.Inject;

public class ReadBookLocalViewModel extends ViewModel {

    private ChapterRepository chapterRepository;


    private MutableLiveData<History> historyMutableLiveData;
    private MutableLiveData<Integer> numberChapter = new MutableLiveData<>(1);
    private MutableLiveData<Book> bookMutableLiveData;


    @Inject
    ReadBookLocalViewModel(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
        init();
    }

    private void init() {
        historyMutableLiveData = new MutableLiveData<>();
        bookMutableLiveData = new MutableLiveData<>();
    }

    private LiveData<Chapter> ChapterLiveData = Transformations.switchMap(numberChapter, i -> {
        if (historyMutableLiveData.getValue() == null) return new MutableLiveData<>();
        return chapterRepository.getChapterLocal(bookMutableLiveData.getValue().getId(), i);
    });

    public LiveData<Chapter> getChapterLiveData() {
        return ChapterLiveData;
    }


    void onNext() {
        if (numberChapter.getValue() == null || historyMutableLiveData.getValue() == null) return;
        int number = numberChapter.getValue();
        int limit = historyMutableLiveData.getValue().getChapterState();
        if (number < limit)
            numberChapter.postValue(number + 1);
    }

    void onPre() {
        if (numberChapter.getValue() == null) return;
        int number = numberChapter.getValue();
        if (number > 1)
            numberChapter.postValue(number - 1);
    }


    void setHistoryMutableLiveData(History history) {
        this.historyMutableLiveData.setValue(history);
        this.bookMutableLiveData.setValue(history.getBook());
        this.numberChapter.setValue(history.getChapterState());
    }
}
