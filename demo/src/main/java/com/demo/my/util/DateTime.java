package com.demo.my.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private final Date datetime;

    public DateTime(Date time) {
        this.datetime = time;
    }

    public DateTime() {
        this.datetime = new Date();
    }

    public String toString(String format) {
        SimpleDateFormat ft = new SimpleDateFormat(format);
        return ft.format(datetime);
    }

    public String toString() {
        SimpleDateFormat ft = new SimpleDateFormat(DATETIME_FORMAT);
        return ft.format(datetime);
    }

    public static String format(Date date, String format) {
        DateTime datetime = new DateTime(date);
        return datetime.toString(format);
    }

    public static String format(Date date) {
        DateTime datetime = new DateTime(date);
        return datetime.toString();
    }

    public static String format() {
        DateTime datetime = new DateTime();
        return datetime.toString();
    }
}
