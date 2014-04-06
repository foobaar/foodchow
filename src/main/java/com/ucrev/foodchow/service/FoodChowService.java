package com.ucrev.foodchow.service;

import com.ucrev.foodchow.dto.FoodChowSearchRequest;
import com.ucrev.foodchow.dto.FoodChowResponse;
import com.ucrev.foodchow.dto.Restaurant;

import java.util.List;

public interface FoodChowService {
    String getRestaurents();
    Long generateRandomGuid();
    List<String> getRandomFoodImageUrls();
    FoodChowResponse doStuff(String zip);
<<<<<<< Updated upstream
    FoodChowResponse getSearchResults(FoodChowSearchRequest request);
=======
    List<Restaurant> topRankRestaurants(double[] imageResults, List<Restaurant> restaurants);

    
>>>>>>> Stashed changes
}
