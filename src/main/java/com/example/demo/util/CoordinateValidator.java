package com.example.demo.util;

public class CoordinateValidator {

    public static boolean isValidLatitude(double latitude) {
        return latitude >= -90.0 && latitude <= 90.0;
    }

    public static boolean isValidLongitude(double longitude) {
        return longitude >= -180.0 && longitude <= 180.0;
    }

    public static boolean isValidCoordinate(double latitude, double longitude) {
        return isValidLatitude(latitude) && isValidLongitude(longitude);
    }

   
    public static void main(String[] args) {
        System.out.println(isValidCoordinate(12.0, 77.0)); // true
        System.out.println(isValidCoordinate(-91.0, 77.0)); // false
        System.out.println(isValidCoordinate(45.0, 190.0)); // false
    }
}
