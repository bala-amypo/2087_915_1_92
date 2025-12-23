package com.example.demo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator {

    /**
     * Validate if a date string is in the given format (e.g., "yyyy-MM-dd")
     */
    public static boolean isValidDate(String dateStr, String pattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Check if a date is in the past (before today)
     */
    public static boolean isPastDate(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }

    /**
     * Check if a date is today or in the future
     */
    public static boolean isTodayOrFuture(LocalDate date) {
        return !date.isBefore(LocalDate.now());
    }

    // ================= Example Main =================
    public static void main(String[] args) {
        System.out.println(isValidDate("2025-12-23", "yyyy-MM-dd")); // true
        System.out.println(isValidDate("23-12-2025", "yyyy-MM-dd")); // false
        System.out.println(isPastDate(LocalDate.of(2020, 1, 1))); // true
        System.out.println(isTodayOrFuture(LocalDate.of(2030, 1, 1))); // true
    }
}
