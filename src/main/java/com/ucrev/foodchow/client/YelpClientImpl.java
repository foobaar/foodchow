package com.ucrev.foodchow.client;

import com.google.gson.Gson;
import com.ucrev.foodchow.dto.YelpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YelpClientImpl implements YelpClient {

    private static String YELP_BASE_URL = "http://api.yelp.com/business_review_search?";

    protected RestTemplate restTemplate = new RestTemplate();

    @Override
    public YelpResponse getRestaurants(String zipcode) {
        String yelpResponse = restTemplate.getForObject(YELP_BASE_URL+"term=cream puffs&location=cincinnati&ywsid=GkEt7fj69eNfI-n7Bv3BPQ",String.class);
        Gson gson = new Gson();
        return gson.fromJson(yelpResponse,YelpResponse.class);
    }
}
