package com.ucrev.foodchow.dto;

import java.util.ArrayList;
import java.util.List;

public class FoodChowResponse {
    private long guid;
    private List<String> imageURLList = new ArrayList<String>();
    private List<Restaurant> restaurants;

    public List<Restaurant> getRestaurants() {return restaurants;}

    public void setRestaurants(List<Restaurant> restaurants) {this.restaurants = restaurants; }

    public long getGuid() {
        return guid;
    }

    public void setGuid(long guid) {
        this.guid = guid;
    }

    public List<String> getImageURLList() {
        return imageURLList;
    }

    public void setImageURLList(List<String> imageURLList) {
        this.imageURLList = imageURLList;
    }
}
