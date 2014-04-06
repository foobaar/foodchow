package com.ucrev.foodchow.service;

import com.ucrev.foodchow.client.YelpClient;
import com.ucrev.foodchow.client.YelpClientImpl;
import com.ucrev.foodchow.dto.FoodChowResponse;
import com.ucrev.foodchow.dto.FoodChowSearchRequest;
import com.ucrev.foodchow.dto.Restaurant;
import com.ucrev.foodchow.dto.RestaurantSort;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.math3.ml.distance.EuclideanDistance;

import java.util.*;

import com.ucrev.foodchow.dto.Restaurant;
import com.ucrev.foodchow.dto.RestaurantSort;
import org.apache.commons.math3.ml.distance.EuclideanDistance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class FoodChowServiceImpl implements FoodChowService{

    //yes yes i will delete this awefullness
    private static List<String> imageUrls;
    private static Map<Long,String> cacheOfGuidVsZip = new HashMap<Long,String>();

    static{
        imageUrls = new ArrayList<String>();
        imageUrls.add("url1");
        imageUrls.add("url2");
        imageUrls.add("url3");
        imageUrls.add("url4");
    }


    public String getRestaurants() {
        YelpClient yelpClient = new YelpClientImpl();
        return null;
    }

    @Override
    public Long generateRandomGuid() {
        return null;
    }


    @Override
    public String getRestaurents() {
        return null;
    }

    public List<String> getRandomFoodImageUrls() {
        return imageUrls;
    }

    @Override
    public FoodChowResponse doStuff(String zip) {
        FoodChowResponse foodChowResponse = new FoodChowResponse();
        long guid = UUID.randomUUID().getMostSignificantBits();
        foodChowResponse.setGuid(guid);
        cacheOfGuidVsZip.put(guid,zip);
        foodChowResponse.setImageURLList(getRandomFoodImageUrls());
        return foodChowResponse;
    }

    @Override
    public FoodChowResponse getSearchResults(FoodChowSearchRequest request) {
       // List<Restaurent> restaurentsInTheNeighbourhood = getRestaurentsForZip(cacheOfGuidVsZip.get(request.getGuid()));
        double[] imageVector = constructImageVector(request);
        double[] normalizedImageVector = getNormalizedImageVector(imageVector);
        return returnRecommendedRestaurents(null, normalizedImageVector);
    }

    private double[] constructImageVector(FoodChowSearchRequest request) {
        List<Double> imageVectorList = new ArrayList<Double>();
        return null;
    }

    private FoodChowResponse returnRecommendedRestaurents(List<Restaurant> restaurentsInTheNeighbourhood, double[] normalizedImageVector) {
        return null;
    }

    private double[] getNormalizedImageVector(double[] imageVector) {
        List<Double> vectorList = Arrays.asList(ArrayUtils.toObject(imageVector));
        double max = Collections.max(vectorList);
        double min = Collections.min(vectorList);

        if(Math.abs(min)>Math.abs(max)){
            max =  Math.abs(min);
        }
        for (int i=0; i<imageVector.length; i++) {
            imageVector[i] = imageVector[i]  / max;
        }

        return imageVector;
    }

    private List<Restaurant> getRestaurentsForZip(String zip) {
        return null;
    }

    public List<Restaurant> topRankRestaurants(double[] imageResults, List<Restaurant> restaurants) {
        EuclideanDistance ed = new EuclideanDistance();
        for(Restaurant restaurant:restaurants){
            double dist = ed.compute(imageResults,restaurant.getCategoryArray());
            restaurant.setDistance(dist);
        }
        return topResults(sortResults(restaurants));
    }

    public List<Restaurant> sortResults(List<Restaurant> restaurants) {
        Collections.sort(restaurants,new RestaurantSort());
         return restaurants;
    }

    public List<Restaurant> topResults(List<Restaurant> restaurants){
        List<Restaurant> topResults = new ArrayList<Restaurant>();
        for(int i=0;i<10;i++){
            topResults.add(restaurants.get(i))   ;
        }
        return topResults;
    }

}
