package com.ucrev.foodchow.client;

import org.springframework.web.client.RestTemplate;

public class YelpClientImpl implements YelpClient {

    RestTemplate restTemplate = new RestTemplate();
    @Override
    public String getRestaurents() {
       return null;
    }
}
