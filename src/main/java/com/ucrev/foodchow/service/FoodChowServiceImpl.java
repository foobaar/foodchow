package com.ucrev.foodchow.service;

import com.ucrev.foodchow.client.YelpClient;
import com.ucrev.foodchow.client.YelpClientImpl;
import com.ucrev.foodchow.dto.*;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.math3.ml.distance.EuclideanDistance;

import java.util.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class FoodChowServiceImpl implements FoodChowService{

    //yes yes i will delete this awefullness
    private static List<String> imageUrls;
    private static Map<Long,String> cacheOfGuidVsZip = new HashMap<Long,String>();
    private YelpClient yelpClient = new YelpClientImpl();

    static{
        imageUrls = new ArrayList<String>();
        imageUrls.add("http://i.imgur.com/J1z6RmU.jpg");
        imageUrls.add("http://i.imgur.com/CMlm55G.jpg");
        imageUrls.add("http://i.imgur.com/dfBiaXU.jpg");
        imageUrls.add("http://i.imgur.com/L92xI9r.jpg");
        imageUrls.add("http://i.imgur.com/nHafpWN.jpg");
        imageUrls.add("http://i.imgur.com/paiXVav.jpg");
        imageUrls.add("http://i.imgur.com/KcKx9uU.jpg");
        imageUrls.add("http://i.imgur.com/BcSOopC.jpg");
        imageUrls.add("http://i.imgur.com/aYmB3eU.jpg");
        imageUrls.add("http://i.imgur.com/aeX8Kr5.jpg");
        imageUrls.add("http://i.imgur.com/kce5iiI.jpg");
        imageUrls.add("http://i.imgur.com/RJaGjt3.jpg");
        imageUrls.add("http://i.imgur.com/61huDTZ.jpg");
        imageUrls.add("http://i.imgur.com/0z6FxH8.jpg");
        imageUrls.add("http://i.imgur.com/3OwIMcT.jpg");
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
        //ahem ahem, random!
        return imageUrls.subList(0,5);
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
        List<Restaurant> restaurentsInTheNeighbourhood = getRestaurentsForZip(cacheOfGuidVsZip.get(request.getGuid()));
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

    private List<Restaurant> getRestaurentsForZip(String zipCode) {
        YelpResponse yelpResponse = yelpClient.getRestaurants(zipCode);
        return yelpResponse.getBusinesses();
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
