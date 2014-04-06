package com.ucrev.foodchow.dto;


import java.util.Comparator;

public class RestaurantSort implements Comparator<Restaurant>{

    @Override
    public int compare(Restaurant r1,Restaurant r2) {
         if(r1.getDistance()>r2.getDistance())
            return -1;
         else if(r1.getDistance()<r2.getDistance())
             return 1;
         else
             return 0;
    }
}
