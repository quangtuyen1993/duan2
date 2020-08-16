package com.example.bookstory.vo;

import android.os.Parcel;
import android.os.Parcelable;

public class LoadPage implements Parcelable {
    private int pageLoadCurrent;
    private int pageLimit;

    public LoadPage() {
    }

    public LoadPage(int pageLoadCurrent, int pageLimit) {
        this.pageLoadCurrent = pageLoadCurrent;
        this.pageLimit = pageLimit;
    }

    public int getPageLoadCurrent() {
        return pageLoadCurrent;
    }

    public void setPageLoadCurrent(int pageLoadCurrent) {
        this.pageLoadCurrent = pageLoadCurrent;
    }

    public int getPageLimit() {
        return pageLimit;
    }

    public void setPageLimit(int pageLimit) {
        this.pageLimit = pageLimit;
    }

    public static Creator<LoadPage> getCREATOR() {
        return CREATOR;
    }

    protected LoadPage(Parcel in) {
        pageLoadCurrent = in.readInt();
        pageLimit = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(pageLoadCurrent);
        dest.writeInt(pageLimit);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LoadPage> CREATOR = new Creator<LoadPage>() {
        @Override
        public LoadPage createFromParcel(Parcel in) {
            return new LoadPage(in);
        }

        @Override
        public LoadPage[] newArray(int size) {
            return new LoadPage[size];
        }
    };
}
