package com.example.bytecamp_raw.Model;

import com.google.firebase.database.Exclude;

/**
 * Created by venkat on 23/2/19.
 */
public class Location {
    public Location(Long lat, Long aLong) {
        Lat = lat;
        Long = aLong;
    }

    public Location() {
    }

    @Exclude
    public Long getLat() {
        return Lat;
    }

    @Exclude
    public void setLat(Long lat) {
        Lat = lat;
    }

    @Exclude
    public Long getLong() {
        return Long;
    }

    @Exclude
    public void setLong(Long aLong) {
        Long = aLong;
    }

    Long Lat,Long;
}
