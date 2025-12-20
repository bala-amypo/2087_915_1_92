package com.example.demo.util;

import java.time.LocalDate;

public class DateValidator {

    private DateValidator() {
    }

    public static boolean isValidDate(LocalDate date) {
        if (date == null) {
            return false;
        }
        return !date.isAfter(LocalDate.now());
    }
}
