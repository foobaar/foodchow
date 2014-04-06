package com.ucrev.foodchow.controller;

import com.google.gson.Gson;
import com.ucrev.foodchow.client.YelpClient;
import com.ucrev.foodchow.client.YelpClientImpl;
import com.ucrev.foodchow.dto.FoodChowResponse;
import com.ucrev.foodchow.dto.FoodChowSearchRequest;
import com.ucrev.foodchow.dto.Restaurant;
import com.ucrev.foodchow.service.FoodChowService;
import com.ucrev.foodchow.service.FoodChowServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/food")
public class FoodChowController {

    FoodChowService service = new FoodChowServiceImpl();
    Gson gson = new Gson();

    @RequestMapping(method = RequestMethod.GET)
    public String welcome() {
        return "index";
    }

    @RequestMapping(value = "initialize", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody FoodChowResponse searchByZip(@RequestParam(value = "zip", required = false) String zip) {
        return service.initialize(zip);
    }

    @RequestMapping(value = "recommmend",method = RequestMethod.POST,produces = "application/json")
    public @ResponseBody List<Restaurant> getSearchResults(@RequestBody FoodChowSearchRequest request) {
         return service.getSearchResults(request).getRestaurants();
        }


    List<Restaurant> makeList(){
        List<Restaurant> restaurants =  new ArrayList<Restaurant>();
        Restaurant restaurant1 =  new Restaurant();
        restaurant1.setName("abcd");
        restaurant1.setAvg_rating("5");
        restaurant1.setUrl("http://yelp.com/biz/nickies-san-francisco");

        Restaurant restaurant2 =  new Restaurant();
        restaurant2.setName("abcd");
        restaurant2.setAvg_rating("5");
        restaurant2.setUrl("http://yelp.com/biz/nickies-san-francisco");
        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        return restaurants;
    }
}
