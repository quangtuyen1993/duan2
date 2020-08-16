package com.example.bookstory.vo;

public class LoadingImg {
    public enum State {
        LAZY, LOADING
    }

    private State state;
    private String urlImg;
    private String idChapter;

    public State getState() {
        return state;
    }

    public LoadingImg(String urlImg) {
        this.state = State.LAZY;
        this.urlImg = urlImg;
    }
    public LoadingImg(State state,String urlImg) {
        this.state = state;
        this.urlImg = urlImg;
    }

    public String getIdChapter() {
        return idChapter;
    }

    public void setIdChapter(String idChapter) {
        this.idChapter = idChapter;
    }

    public LoadingImg(String urlImg, String idChapter) {
        this.state = State.LAZY;
        this.urlImg = urlImg;
        this.idChapter = idChapter;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}
