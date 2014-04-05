package com.ucrev.foodchow.client;

import org.springframework.web.client.RestTemplate;

/**
 * Created by ECSB Dev on 4/5/14.
 */
public class YelpClientImpl implements YelpClient {

    RestTemplate restTemplate = new RestTemplate();
    @Override
    public String getRestaurents() {
       return null;
    }
}
