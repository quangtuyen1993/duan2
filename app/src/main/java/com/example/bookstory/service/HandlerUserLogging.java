package com.example.bookstory.service;

import com.example.bookstory.vo.User;

public class HandlerUserLogging {
    public enum Status {
        LOADING,
        SUCCESS,
        ERR,
    }

    public final Status status;
    public final User user;
    public final Throwable err;

    public HandlerUserLogging(Status status, User user, Throwable err) {
        this.status = status;
        this.user = user;
        this.err = err;
    }

    public static HandlerUserLogging success(User data) {
        return new HandlerUserLogging(Status.SUCCESS, data, null);
    }

    public static HandlerUserLogging error(Throwable error) {
        return new HandlerUserLogging(Status.ERR, null, error);
    }

    public static HandlerUserLogging loading() {
        return new HandlerUserLogging(Status.LOADING, null, null);
    }
}
