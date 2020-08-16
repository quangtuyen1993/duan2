package com.example.bookstory.vo;

import com.google.gson.annotations.SerializedName;

public class UserWrapper {
    @SerializedName("message")
    String message;
    @SerializedName("user")
    User user;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserWrapper(String message, User user) {
        this.message = message;
        this.user = user;
    }
}
