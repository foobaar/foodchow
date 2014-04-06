package com.ucrev.foodchow.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YelpResponse {
    private List<Restaurant> businesses = new ArrayList<Restaurant>();


    public List<Restaurant> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Restaurant> restaurants) {
        this.businesses = restaurants;
    }
}
