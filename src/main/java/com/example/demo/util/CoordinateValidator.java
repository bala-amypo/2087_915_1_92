package com.example.demo.util;


public class CoordinateValidator {
public static void validate(Double lat, Double lon) {
if (lat == null || lat < -90 || lat > 90) {
throw new IllegalArgumentException("Invalid latitude");
}
if (lon == null || lon < -180 || lon > 180) {
throw new IllegalArgumentException("Invalid longitude");
}
}
}