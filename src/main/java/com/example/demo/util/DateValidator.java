package com.example.demo.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateUtil {

    private DateUtil() {
        // private constructor to prevent instantiation
    }

    /**
     * Check if a given date is not in the future.
     * @param date LocalDate to validate
     * @return true if date is today or in the past
     */
    public static boolean isNotFutureDate(LocalDate date) {
        if (date == null) return false;
        return !date.isAfter(LocalDate.now());
    }

    /**
     * Check if a given datetime is not in the future.
     * @param dateTime LocalDateTime to validate
     * @return true if dateTime is now or in the past
     */
    public static boolean isNotFutureDateTime(LocalDateTime dateTime) {
        if (dateTime == null) return false;
        return !dateTime.isAfter(LocalDateTime.now());
    }

    /**
     * Check if a given date is today.
     * @param date LocalDate to validate
     * @return true if date is today
     */
    public static boolean isToday(LocalDate date) {
        if (date == null) return false;
        return date.equals(LocalDate.now());
    }
}
