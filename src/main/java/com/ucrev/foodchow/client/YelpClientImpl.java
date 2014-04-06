package com.ucrev.foodchow.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YelpClientImpl implements YelpClient {

   protected RestTemplate restTemplate = new RestTemplate();

    @Override
    public String getRestaurents() {
        return restTemplate.getForObject("http://api.yelp.com/business_review_search?term=cream puffs&location=cincinnati&ywsid=GkEt7fj69eNfI-n7Bv3BPQ",String.class);
    }

}
