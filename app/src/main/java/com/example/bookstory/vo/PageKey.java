package com.example.bookstory.vo;

public class PageKey {
    private int page;
   private String key;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public PageKey(int page, String key) {
        this.page = page;
        this.key = key;
    }
}
