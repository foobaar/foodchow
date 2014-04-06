package com.ucrev.foodchow.service;

import com.ucrev.foodchow.client.YelpClient;
import com.ucrev.foodchow.client.YelpClientImpl;
import com.ucrev.foodchow.dto.FoodChowResponse;

import java.util.List;
import java.util.UUID;

public class FoodChowServiceImpl implements FoodChowService

    @Override
    public String getRestaurants() {
        YelpClient yelpClient = new YelpClientImpl();
        return null;
    }

    @Override
    public Long generateRandomGuid() {
        return UUID.randomUUID().getMostSignificantBits();
    }

    public List<String> getRandomFoodImageUrls() {
        return null;
    }

    @Override
    public FoodChowResponse doStuff(String zip) {
        FoodChowResponse foodChowResponse = new FoodChowResponse();
        foodChowResponse.setGuid(UUID.randomUUID().getMostSignificantBits());
        foodChowResponse.setRandomFoodImageUrls(getRandomFoodImageUrls());
        return foodChowResponse;
    }
}
