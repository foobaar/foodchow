package com.ucrev.foodchow.service;

import com.ucrev.foodchow.dto.FoodChowResponse;

import java.util.List;

public interface FoodChowService {
    String getRestaurants();
    Long generateRandomGuid();
    List<String> getRandomFoodImageUrls();
    FoodChowResponse doStuff(String zip);
}
