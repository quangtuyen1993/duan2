package com.example.bookstory.util;

import androidx.databinding.InverseMethod;

public class ConvertString {
    @InverseMethod("convertStringToNumber")
    public static String convertNumberString(int number) {
        return String.valueOf(number);
    }

    public static int convertStringToNumber(String number) {
        return Integer.parseInt(number);
    }
}
