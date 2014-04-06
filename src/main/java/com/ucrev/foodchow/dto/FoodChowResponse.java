package com.ucrev.foodchow.dto;

import java.util.ArrayList;
import java.util.List;

public class FoodChowResponse {
    private long guid;
    private List<String> randomFoodImageUrls = new ArrayList<String>();

    public long getGuid() {
        return guid;
    }

    public void setGuid(long guid) {
        this.guid = guid;
    }

    public List<String> getRandomFoodImageUrls() {
        return randomFoodImageUrls;
    }

    public void setRandomFoodImageUrls(List<String> randomFoodImageUrls) {
        this.randomFoodImageUrls = randomFoodImageUrls;
    }

}
