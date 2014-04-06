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

    private static List<Image> selectedImages =new ArrayList<Image>();

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
        selectedImages.add(new Image("http://i.imgur.com/J1z6RmU.jpg",new double[]{0,0,0,0,0,0,0,0,0,0},0,true));
        selectedImages.add(new Image("http://i.imgur.com/CMlm55G.jpg",new double[]{1,1,1,1,0,1,1,1,0,0},0,true));
        selectedImages.add(new Image("http://i.imgur.com/dfBiaXU.jpg",new double[]{1,1,0,0,0,1,0,1,0,0},0,true));
        selectedImages.add(new Image("http://i.imgur.com/L92xI9r.jpg",new double[]{0,0,1,1,0,0,0,0,1,0},0,true));
        selectedImages.add(new Image("http://i.imgur.com/nHafpWN.jpg",new double[]{0,1,1,1,0,0,0,0,0,0},0,true));


        //ahem ahem, random!
        return imageUrls.subList(0,5);
    }

    @Override
    public FoodChowResponse initialize(String zip) {
        FoodChowResponse foodChowResponse = new FoodChowResponse();
        long guid = UUID.randomUUID().getMostSignificantBits();
        foodChowResponse.setGuid(guid);
        cacheOfGuidVsZip.put(guid,zip);
        foodChowResponse.setImageURLList(getRandomFoodImageUrls());
        return foodChowResponse;
    }

    @Override
    public FoodChowResponse getSearchResults(FoodChowSearchRequest request) {
        List<Restaurant> restaurentsInTheNeighbourhood = getRestaurantsForZip(cacheOfGuidVsZip.get(request.getGuid()));
        System.out.println(restaurentsInTheNeighbourhood.size());
        double[] imageVector = constructImageVector(request);
        double[] normalizedImageVector = getNormalizedImageVector(imageVector);
        return returnRecommendedRestaurants(restaurentsInTheNeighbourhood, normalizedImageVector);
    }

    private double[] constructImageVector(FoodChowSearchRequest request) {
        List<Image> votedImages = mapRequestToSeletedImagesList(request);
        return getImageVector(votedImages);
    }

    private double[] getImageVector(List<Image> votedImages) {
        double[] finalVector = new double[5];
        for(Image image:votedImages){
            finalVector = addVectors(finalVector,image.getImageVector());
        }
        return finalVector;
    }

    private double[] addVectors(double[] finalVector, double[] imageVector) {
        double[] array1and2 = new double[finalVector.length + imageVector.length];
        System.arraycopy(finalVector, 0, array1and2, 0, finalVector.length);
        System.arraycopy(imageVector, 0, array1and2, imageVector.length, imageVector.length);
        return array1and2;
    }


    private List<Image> mapRequestToSeletedImagesList(FoodChowSearchRequest request) {
        List<Image> images = new ArrayList<Image>();
        for(ImageObject imageObject:request.getImageResponses()){
            for(Image image:selectedImages){
                if(imageObject.getImageId().equals(image.getImageId())){
                    image.setVote(imageObject.getResponse());
                    images.add(image);
                }
            }
        }
        return images;
    }

    private FoodChowResponse returnRecommendedRestaurants(List<Restaurant> restaurantsInTheNeighbourhood, double[] normalizedImageVector) {
        List<Restaurant> restaurants =topRankRestaurants(normalizedImageVector, restaurantsInTheNeighbourhood);
        FoodChowResponse foodChowResponse = new FoodChowResponse();
        foodChowResponse.setRestaurants(restaurants);
        return foodChowResponse;
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

    private List<Restaurant> getRestaurantsForZip(String zipCode) {
        YelpResponse yelpResponse = yelpClient.getRestaurants(zipCode);
        return yelpResponse.getRestaurants();
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
        for(Restaurant rest:topResults)   {
            topResults.add(rest);
        }
        return topResults;
    }

}
