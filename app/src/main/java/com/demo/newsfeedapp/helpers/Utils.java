package com.demo.newsfeedapp.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Vineeth on 4/14/2019.
 */
public class Utils {

    public static String getDayOfWeekFromDate(String date) {
        String result = date;
        try {
            Date formattedDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(date);
            result = new SimpleDateFormat("EEEE", Locale.getDefault()).format(formattedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String formatDegreeCelsiusData(Float avgtempC) {
        int temp = Math.round(avgtempC);
        return String.format("%s %s", temp, 'C');
    }

    public static String formatDegreeCelsius(Float tempC) {
        String result = "";
        try {
            int value = Math.round(tempC);
            char tmp = 0x00B0;
            result = String.format("%s%s", value, tmp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
