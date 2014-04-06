package com.ucrev.foodchow.service;

import com.ucrev.foodchow.dto.FoodChowSearchRequest;
import com.ucrev.foodchow.dto.FoodChowResponse;

import java.util.List;

public interface FoodChowService {
    String getRestaurents();
    Long generateRandomGuid();
    List<String> getRandomFoodImageUrls();
    FoodChowResponse doStuff(String zip);
    FoodChowResponse getSearchResults(FoodChowSearchRequest request);
}
