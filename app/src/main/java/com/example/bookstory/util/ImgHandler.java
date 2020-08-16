package com.example.bookstory.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.bookstory.R;
import com.squareup.picasso.Picasso;

public class ImgHandler {
    @BindingAdapter("ImgUrl")
    public static void setImgUrl(ImageView img, String url) {
        Picasso.get().load(url)
                .placeholder(R.drawable.ic_library_books_black_24dp)
                .resize(960, 1080)
                .centerInside()
                .into(img);
    }
}
