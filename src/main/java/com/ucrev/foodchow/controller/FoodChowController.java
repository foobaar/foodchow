package com.ucrev.foodchow.controller;

import com.ucrev.foodchow.client.YelpClient;
import com.ucrev.foodchow.client.YelpClientImpl;
import com.ucrev.foodchow.dto.FoodChowResponse;
import com.ucrev.foodchow.dto.FoodChowSearchRequest;
import com.ucrev.foodchow.service.FoodChowService;
import com.ucrev.foodchow.service.FoodChowServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/food")
public class FoodChowController {

    FoodChowService service = new FoodChowServiceImpl();

    YelpClient yelpClient = new YelpClientImpl();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody FoodChowResponse searchByZip(@RequestParam(value = "zip", required = false) String zip) {
        return service.doStuff(zip);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody FoodChowResponse getSearchResults(FoodChowSearchRequest request) {
        return service.getSearchResults(request);
    }

}
