package com.tongwudi.algorithm.Tool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private  DateUtil(){};
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String formatDate2(LocalDateTime date) {
        return formatter.format(date);
    }

    public static LocalDateTime parse2(String dateNow) {
        return LocalDateTime.parse(dateNow, formatter);
    }
}
