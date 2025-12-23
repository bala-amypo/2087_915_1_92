package com.example.demo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator {

    public static boolean isValidDate(String dateStr, String pattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isPastDate(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }

   
    public static boolean isTodayOrFuture(LocalDate date) {
        return !date.isBefore(LocalDate.now());
    }

    public static void main(String[] args) {
        System.out.println(isValidDate("2025-12-23", "yyyy-MM-dd")); 
        System.out.println(isValidDate("23-12-2025", "yyyy-MM-dd")); 
        System.out.println(isPastDate(LocalDate.of(2020, 1, 1))); 
        System.out.println(isTodayOrFuture(LocalDate.of(2030, 1, 1)));
    }
}
