package com.example.demo.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateUtil {

    // Check if date/time is in the future
    public static boolean isFuture(LocalDateTime dateTime) {
        return dateTime != null && dateTime.isAfter(LocalDateTime.now());
    }

    // Check if date is today
    public static boolean isToday(LocalDate date) {
        return date != null && date.equals(LocalDate.now());
    }

    // Convert LocalDateTime to LocalDate
    public static LocalDate toLocalDate(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.toLocalDate() : null;
    }

    // Convert LocalDate to LocalDateTime at start of day
    public static LocalDateTime toStartOfDay(LocalDate date) {
        return date != null ? date.atStartOfDay() : null;
    }
}
