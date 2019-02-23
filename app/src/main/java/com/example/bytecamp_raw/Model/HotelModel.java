package com.example.bytecamp_raw.Model;

import com.google.firebase.database.Exclude;

/**
 * Created by venkat on 23/2/19.
 */
public class HotelModel {
    String Name;
    String FoodType;
    String Freshness;
    String Quantity;
    String SensorReading;


    @Exclude
    public String getName() {
        return Name;
    }
    @Exclude

    public void setName(String name) {
        Name = name;
    }

    @Exclude
    public String getFoodType() {
        return FoodType;
    }

    @Exclude
    public void setFoodType(String foodType) {
        FoodType = foodType;
    }

    @Exclude
    public String getFreshness() {
        return Freshness;
    }
    @Exclude
    public void setFreshness(String freshness) {
        Freshness = freshness;
    }

    @Exclude
    public String getQuantity() {
        return Quantity;
    }

    @Exclude
    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    @Exclude
    public String getSensorReading() {
        return SensorReading;
    }
    @Exclude
    public void setSensorReading(String sensorReading) {
        SensorReading = sensorReading;
    }

    public HotelModel() {
    }

    public HotelModel(String name, String foodType, String freshness, String quantity, String sensorReading) {
        Name = name;
        FoodType = foodType;
        Freshness = freshness;
        Quantity = quantity;
        SensorReading = sensorReading;
    }
}
