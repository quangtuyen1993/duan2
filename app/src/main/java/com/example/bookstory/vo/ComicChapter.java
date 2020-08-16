package com.example.bookstory.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComicChapter {
    @SerializedName("date")
    private String date;
    @SerializedName("_id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("content")
    private List<String> content;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public ComicChapter(String date, String id, String name, List<String> content) {
        this.date = date;
        this.id = id;
        this.name = name;
        this.content = content;
    }
}
