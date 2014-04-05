package com.ucrev.foodchow.service;

import com.ucrev.foodchow.client.YelpClient;
import com.ucrev.foodchow.client.YelpClientImpl;

public class FoodChowServiceImpl implements FoodChowService {
    @Override
    public String getRestaurents() {
        YelpClient yelpClient = new YelpClientImpl();
        return yelpClient.getRestaurents();
    }
}
