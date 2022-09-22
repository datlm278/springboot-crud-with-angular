package com.example.springbootcrudwithangular.common.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class DateUtils {
    public static String getCurrentTime(String format, String timezone) {
        String dateTimeFormat = "";
        if ("YYYY-MM-DD".equals(format)) {
            dateTimeFormat = "yyyy-MM-dd ";
        } else {
            dateTimeFormat = "dd-MM-yyyy ";
        }
        if ("HH:mm:ss".equals(format)) {
            dateTimeFormat += "HH:mm:ss";
        } else {
            dateTimeFormat += "a hh:mm:ss";
        }
        return Instant.now().atZone(ZoneId.of(timezone))
                .format(DateTimeFormatter.ofPattern(dateTimeFormat).withLocale(Locale.ENGLISH));
    }
}
