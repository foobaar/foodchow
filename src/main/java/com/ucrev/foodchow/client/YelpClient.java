package com.ucrev.foodchow.client;

import com.ucrev.foodchow.dto.YelpResponse;


public interface YelpClient {
   public YelpResponse getRestaurants(String zipcode);
}
