package com.example.bookstory.ui.comic.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstory.R;
import com.example.bookstory.ui.comic.ComicActivity;
import com.example.bookstory.vo.LoadingImg;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ComicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static int LOADING = 10001;
    private static int LAZY = 20002;

    private static CallbackBitmap callbackBitmap;
    Handler handler;

    public ComicAdapter() {
        handler = new Handler();
    }

    public void setCallbackBitmap(CallbackBitmap callbackBitmap) {
        ComicAdapter.callbackBitmap = callbackBitmap;
    }

    private List<LoadingImg> urls = new ArrayList<>();

    public void setUrls(List<LoadingImg> urls) {
        this.urls = urls;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (urls.get(position).getState() == LoadingImg.State.LAZY)
            return LAZY;
        return LOADING;
    }

    public void setItemVisible(int position) {

        if (position < urls.size() && position >= 0) {
            LoadingImg loadingImg = urls.get(position);
            if (loadingImg.getState() == LoadingImg.State.LAZY) {
                loadingImg.setState(LoadingImg.State.LOADING);
                notifyItemRangeChanged(position, 2);

            }
        }

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == LOADING) {
            view = layoutInflater.inflate(R.layout.item_comic_content, parent, false);
            return new ImgViewHolder(view);
        } else {
            view = layoutInflater.inflate(R.layout.item_loading, parent, false);
            return new LoadViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LoadingImg urlImg = urls.get(position);
        if (holder instanceof ImgViewHolder)
            ((ImgViewHolder) holder).bind(urlImg);
        if (holder instanceof LoadViewHolder)
            ((LoadViewHolder) holder).bind();

    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    static class ImgViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;

        ImgViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bind(LoadingImg loadingImg) {
            pic = itemView.findViewById(R.id.img_pic);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((ComicActivity) itemView.getContext()).
                    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int height = displayMetrics.heightPixels;
            int width = displayMetrics.widthPixels;
            Picasso.get()
                    .load(loadingImg.getUrlImg())
                    .fit()
                    .centerCrop()
                    .into(pic);

        }
    }

    static class LoadViewHolder extends RecyclerView.ViewHolder {
        public LoadViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bind() {
        }
    }

    public interface CallbackBitmap {
        void getBitMap(Bitmap bitmap, String idChapter, int position);
    }
}
