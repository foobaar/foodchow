package com.ucrev.foodchow.dto;

import java.util.ArrayList;
import java.util.List;

public class YelpResponse {
    List<Restaurent> Restaurents = new ArrayList<Restaurent>();


    public List<Restaurent> getRestaurents() {
        return Restaurents;
    }

    public void setRestaurents(List<Restaurent> restaurents) {
        Restaurents = restaurents;
    }
}
