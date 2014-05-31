package com.ucrev.foodchow.service;

import com.ucrev.foodchow.dto.FoodChowSearchRequest;
import com.ucrev.foodchow.dto.FoodChowResponse;
import com.ucrev.foodchow.dto.Restaurant;

import java.util.List;

public interface FoodChowService {
    FoodChowResponse initialize(String zip);
    FoodChowResponse getSearchResults(FoodChowSearchRequest request);


}
