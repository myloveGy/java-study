package com.study.my.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换
 */
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        // 将日期转换
        String formatString = s.contains("-") ? "yyyy-MM-dd" : "yyyy/MM/dd";
        SimpleDateFormat format = new SimpleDateFormat(formatString);

        try {
            return format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
