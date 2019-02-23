package com.example.bytecamp_raw.Model;

/**
 * Created by venkat on 23/2/19.
 */
public class Location {
    public Location(String lat, String aLong) {
        Lat = lat;
        Long = aLong;
    }

    public Location() {
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getLong() {
        return Long;
    }

    public void setLong(String aLong) {
        Long = aLong;
    }

    String Lat,Long;
}
