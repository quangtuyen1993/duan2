package com.example.bookstory.util;

public class Event<T> {
    private T t;
    private boolean hasBeenHandler = false;

    public Event(T t) {
        this.t = t;
    }

    public T getContentIfNotHandler() {
        if (hasBeenHandler) {
            return null;
        } else {
            hasBeenHandler = true;
            return t;
        }
    }

    public T peekContent() {
        return t;
    }
}
