package com.example.bookstory.vo;

public abstract class HandlerResult<T> {
    public enum Status {
        LOADING, ERROR, SUCCESS
    }
    public Status status;
    public HandlerResult(Status status) {
        this.status = status;
    }
    public static final class Success<T> extends HandlerResult<T> {
        public T t;
        public Success(T t) {
            super(Status.SUCCESS);
            this.t = t;
        }
    }
    public static final class Error<T> extends HandlerResult<T> {
        public Throwable err;
        public Error(Throwable throwable) {
            super(Status.ERROR);
            err = throwable;
        }
    }
}
