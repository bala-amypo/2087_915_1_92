package com.example.demo.util;

public class CoordinateValidator {

    private CoordinateValidator() {
    }

    // Validate latitude (-90 to 90)
    public static boolean isValidLatitude(double latitude) {
        return latitude >= -90 && latitude <= 90;
    }

    // Validate longitude (-180 to 180)
    public static boolean isValidLongitude(double longitude) {
        return longitude >= -180 && longitude <= 180;
    }
}
