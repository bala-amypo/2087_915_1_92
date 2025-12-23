package com.example.demo.util;

public class CoordinateValidator {

    private CoordinateValidator() {
    }
    public static boolean isValidLatitude(double latitude) {
        return latitude >= -90 && latitude <= 90;
    }
    public static boolean isValidLongitude(double longitude) {
        return longitude >= -180 && longitude <= 180;
    }
}