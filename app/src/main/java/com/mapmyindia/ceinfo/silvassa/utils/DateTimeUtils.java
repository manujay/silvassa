package com.mapmyindia.ceinfo.silvassa.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by sonitek on 10/6/2015.
 */
public class DateTimeUtils {

    public static String getformattedDate(String param) {
        SimpleDateFormat format = new SimpleDateFormat(Format.yyyy_MM_dd_HH_mm_ss, Locale.getDefault());
        String string = "";

        try {
            Date date = format.parse(param);

            System.out.printf("%nDate : %ta, %te %tb %tY", date, date, date, date);

            string = String.format(Locale.getDefault(), "%ta, %te %tb %tY", date, date, date, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return string;
    }

    public static String getformattedTime(String param) {
        SimpleDateFormat format = new SimpleDateFormat(Format.HH_mm, Locale.getDefault());
        String string = "";

        try {
            Date date = format.parse(param);
            string = String.format(Locale.getDefault(), "%tI:%tM: %Tp", date, date, date);

            System.out.printf("%nTime : %tI:%tM: %Tp", date, date, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return string;
    }

    public static String getformattedDateTime(String param) {
        SimpleDateFormat format = new SimpleDateFormat(Format.yyyy_MM_dd_HH_mm_ss, Locale.getDefault());
        String string = "";

        try {
            Date date = format.parse(param);
            string = String.format(Locale.getDefault(), "%ta, %te %tb %tY ,%tI:%tM: %Tp", date, date, date, date, date, date, date);

            System.out.printf("%nDate : %ta, %te %tb %tY, Time : %tI:%tM: %Tp", date, date, date, date, date, date, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return string;
    }

    public static String getFormattedDatefromLong(long timeInMillis) {

        SimpleDateFormat sdf = new SimpleDateFormat(Format.dd_MM_yyyy, Locale.getDefault());

        Date date = new Date(timeInMillis);

        return sdf.format(date);
    }

    public interface Format {
        String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
        String dd_MM_yyyy = "dd/MM/yyyy";
        String HH_mm_ss = "HH:mm:ss";
        String HH_mm = "HH:mm";
    }
}
