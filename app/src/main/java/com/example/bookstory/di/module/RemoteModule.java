package com.example.bookstory.di.module;

import com.example.bookstory.service.BookApi;
import com.example.bookstory.service.BookTypeApi;
import com.example.bookstory.service.ChapterApi;
import com.example.bookstory.service.ComicChapterApi;
import com.example.bookstory.service.FeedApi;
import com.example.bookstory.service.HistoryApi;
import com.example.bookstory.service.UserApi;
import com.example.bookstory.service.UserWrapperApi;
import org.jetbrains.annotations.NotNull;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RemoteModule {
    @Provides
    public BookApi providerBookApi(@NotNull Retrofit retrofit) {
        return retrofit.create(BookApi.class);
    }

    @Provides
    public ChapterApi providerChapterApi(@NotNull Retrofit retrofit) {
        return retrofit.create(ChapterApi.class);
    }

    @Provides
    public BookTypeApi providerBookTypeApi(Retrofit retrofit) {
        return retrofit.create(BookTypeApi.class);
    }

    @Provides
    public UserApi providerUserApi(@NotNull Retrofit retrofit) {
        return retrofit.create(UserApi.class);
    }

    @Provides
    public FeedApi providerFeedApi(@NotNull Retrofit retrofit) {
        return retrofit.create(FeedApi.class);
    }

    @Provides
    public UserWrapperApi providerUserWrapperApi(@NotNull Retrofit retrofit) {
        return retrofit.create(UserWrapperApi.class);
    }

    @Provides
    public ComicChapterApi providerComicChapterApi(@NotNull Retrofit retrofit) {
        return retrofit.create(ComicChapterApi.class);
    }

    @Provides
    public HistoryApi providerHistoryApi(@NotNull Retrofit retrofit) {
        return retrofit.create(HistoryApi.class);
    }

}
