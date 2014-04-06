package com.ucrev.foodchow.service;

import com.ucrev.foodchow.client.YelpClient;
import com.ucrev.foodchow.client.YelpClientImpl;
import com.ucrev.foodchow.dto.FoodChowResponse;
import com.ucrev.foodchow.dto.FoodChowSearchRequest;
import com.ucrev.foodchow.dto.Restaurent;
import org.apache.commons.lang.ArrayUtils;

import java.util.*;

public class FoodChowServiceImpl implements FoodChowService {
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

    @Override
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
        List<Restaurent> restaurentsInTheNeighbourhood = getRestaurentsForZip(cacheOfGuidVsZip.get(request.getGuid()));
        double[] imageVector = constructImageVector(request);
        double[] normalizedImageVector = getNormalizedImageVector(imageVector);
        return returnRecommendedRestaurents(restaurentsInTheNeighbourhood, normalizedImageVector);
    }

    private double[] constructImageVector(FoodChowSearchRequest request) {
        List<Double> imageVectorList = new ArrayList<Double>();
        return null;
    }

    private FoodChowResponse returnRecommendedRestaurents(List<Restaurent> restaurentsInTheNeighbourhood, double[] normalizedImageVector) {
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

    private List<Restaurent> getRestaurentsForZip(String zip) {
        return null;
    }


}
