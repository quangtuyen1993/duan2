package com.example.bookstory.data.response;

import android.os.AsyncTask;

import com.example.bookstory.dao.ContentComicDAO;
import com.example.bookstory.service.ComicChapterApi;
import com.example.bookstory.vo.ComicChapter;
import com.example.bookstory.vo.ContentComic;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ComicChapterRepository {
    private ComicChapterApi comicChapterApi;
    ContentComicDAO contentComicDAO;

    @Inject
    ComicChapterRepository(ComicChapterApi comicChapterApi, ContentComicDAO contentComicDAO) {
        this.comicChapterApi = comicChapterApi;
        this.contentComicDAO = contentComicDAO;
    }

    public Observable<ComicChapter> fetchComicChapter(String idBook, int chapNumber) {
        return comicChapterApi.fetchChap(idBook, chapNumber);
    }
    public void insertContentComic(ContentComic contentComic){
        AsyncTask.execute(()->
        {
            contentComicDAO.saveImg(contentComic);
        });
    }
}
