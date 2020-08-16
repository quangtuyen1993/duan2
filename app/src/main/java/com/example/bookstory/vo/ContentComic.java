package com.example.bookstory.vo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.sql.Blob;
import java.util.List;

@Entity(indices = {@Index(value = {"idChapter", "position"},
        unique = true)}
)
public class ContentComic {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;

    @ColumnInfo
    public String idChapter;

    @ColumnInfo
    public int position;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    public byte[] imgBlob;


    public ContentComic(int id, String idChapter, byte[] imgBlob) {
        this.id = id;
        this.idChapter = idChapter;
        this.imgBlob = imgBlob;
    }

    @Ignore
    public ContentComic(String idChapter, byte[] imgBlob, int position) {
        this.idChapter = idChapter;
        this.position = position;
        this.imgBlob = imgBlob;
    }
}
