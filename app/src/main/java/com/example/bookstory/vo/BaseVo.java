package com.example.bookstory.vo;

import com.google.gson.annotations.SerializedName;

public abstract class BaseVo {
    @SerializedName("_id")
    public String id;

    public BaseVo(String id) {
        this.id = id;
    }
}
