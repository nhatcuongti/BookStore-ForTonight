package com.example.bookstore.utils;

import android.util.Log;

import java.text.DecimalFormat;

/**
 * Author : Hào
 * Mô tả : Khi làm có liên quan tới hiển thị tiền thì dùng hàm này
 *  -String convertNumberToSTring(int number) : Dùng để chuyển một số nguyên kiểu int number về dạng
 *  String theo format như ("100,000") .
 *
 *  -int convertStringToNumber(String number) : Dùng để chuyển một chuỗi format như trên về kiểu số
 *  integer. Ví dụ : "100,000" => 100000
 */
public class ProcessCurrency {
    static public String convertNumberToString(int number){
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(number);
    }

    static public int convertStringToNumber(String number){
        String[] arrNumber = number.split(",");
        String numberValue = arrNumber[0];
        for (int i = 1; i < arrNumber.length; i++)
            numberValue += arrNumber[i];

        return Integer.valueOf(numberValue).intValue();
    }
}
