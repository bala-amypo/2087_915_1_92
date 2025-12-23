package com.example.demo.util;

public class CoordinateUtil {

    // Validate latitude
    public static boolean isValidLatitude(Double lat) {
        return lat != null && lat >= -90.0 && lat <= 90.0;
    }

    // Validate longitude
    public static boolean isValidLongitude(Double lon) {
        return lon != null && lon >= -180.0 && lon <= 180.0;
    }

    // Check if coordinates are within a bounding box
    public static boolean isWithinBounds(Double lat, Double lon,
                                         Double minLat, Double maxLat,
                                         Double minLon, Double maxLon) {
        return isValidLatitude(lat) && isValidLongitude(lon)
                && lat >= minLat && lat <= maxLat
                && lon >= minLon && lon <= maxLon;
    }
}
