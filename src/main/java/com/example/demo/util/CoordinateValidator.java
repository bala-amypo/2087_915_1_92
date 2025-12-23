package com.example.demo.util;

public class CoordinateUtil {

    private CoordinateUtil() {
        // private constructor to prevent instantiation
    }

    /**
     * Validate latitude value.
     * @param latitude latitude to validate
     * @return true if valid, else false
     */
    public static boolean isValidLatitude(Double latitude) {
        if (latitude == null) return false;
        return latitude >= -90.0 && latitude <= 90.0;
    }

    /**
     * Validate longitude value.
     * @param longitude longitude to validate
     * @return true if valid, else false
     */
    public static boolean isValidLongitude(Double longitude) {
        if (longitude == null) return false;
        return longitude >= -180.0 && longitude <= 180.0;
    }

    /**
     * Validate both latitude and longitude.
     * @param latitude latitude
     * @param longitude longitude
     * @return true if both valid, else false
     */
    public static boolean isValidCoordinate(Double latitude, Double longitude) {
        return isValidLatitude(latitude) && isValidLongitude(longitude);
    }
}
