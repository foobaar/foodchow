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

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
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

    @RequestMapping(value = "recommmend",method = RequestMethod.POST,produces = "application/json; charset=utf-8",headers = {"Content-type=application/json"})
    public @ResponseBody List<Restaurant> getSearchResults(@RequestBody String request) {
        FoodChowSearchRequest foodChowSearchRequest = gson.fromJson(request,FoodChowSearchRequest.class);
        return service.getSearchResults(foodChowSearchRequest).getRestaurants();
        }
}
