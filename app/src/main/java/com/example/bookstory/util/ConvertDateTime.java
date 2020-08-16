package com.example.bookstory.util;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.TimeZone;

public class ConvertDateTime {
    @SuppressLint("SimpleDateFormat")
    public static String convertDateTime(String dateString) {

        try {

            String ISO_8601_24H_FULL_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
            TimeZone UTC;
            UTC = TimeZone.getTimeZone("ICT");
            TimeZone.setDefault(UTC);
            final SimpleDateFormat sdf = new SimpleDateFormat(ISO_8601_24H_FULL_FORMAT);
            sdf.setTimeZone(UTC);

            return sdf.parse(dateString).toString();
        } catch (Exception ex) {
            Log.e("ConvertDateTime", Objects.requireNonNull(ex.getMessage()));
        }
        return dateString;
    }
}
