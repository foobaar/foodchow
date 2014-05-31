package com.ucrev.foodchow.service;

import com.ucrev.foodchow.client.YelpClient;
import com.ucrev.foodchow.client.YelpClientImpl;
import com.ucrev.foodchow.dto.FoodChowResponse;
import com.ucrev.foodchow.dto.FoodChowSearchRequest;
import com.ucrev.foodchow.dto.Image;
import com.ucrev.foodchow.dto.ImageObject;
import com.ucrev.foodchow.dto.Restaurant;
import com.ucrev.foodchow.dto.RestaurantSort;
import com.ucrev.foodchow.dto.YelpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.springframework.stereotype.Component;

@Component
public class FoodChowServiceImpl implements FoodChowService {

  //yes yes i will delete this awefullness
  private static List<String> imageUrls;
  private static Map<Long, String> cacheOfGuidVsZip;
  private YelpClient yelpClient = new YelpClientImpl();

  private static List<Image> selectedImages;

  static {
    cacheOfGuidVsZip = new HashMap<Long, String>();
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


  public List<String> getRandomFoodImageUrls() {
    Collections.shuffle(imageUrls);
    List<String> subListOfImageUrls = imageUrls.subList(0, 5);
    addToSelectedImages(subListOfImageUrls);
    return subListOfImageUrls;
  }

  private void addToSelectedImages(List<String> imageUrls) {
    selectedImages = new ArrayList<Image>();
    selectedImages.add(
        new Image(imageUrls.get(0), new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0,
            true));
    selectedImages.add(
        new Image(imageUrls.get(1), new double[]{1, 1, 1, 1, 0, 1, 1, 1, 0, 0}, 0,
            true));
    selectedImages.add(
        new Image(imageUrls.get(2), new double[]{1, 1, 0, 0, 0, 1, 0, 1, 0, 0}, 0,
            true));
    selectedImages.add(
        new Image(imageUrls.get(3), new double[]{0, 0, 1, 1, 0, 0, 0, 0, 1, 0}, 0,
            true));
    selectedImages.add(
        new Image(imageUrls.get(4), new double[]{0, 1, 1, 1, 0, 0, 0, 0, 0, 0}, 0,
            true));
  }

  @Override
  public FoodChowResponse initialize(String zip) {
    FoodChowResponse foodChowResponse = new FoodChowResponse();
    long guid = UUID.randomUUID().getMostSignificantBits();
    foodChowResponse.setGuid(guid);
    cacheOfGuidVsZip.put(guid, zip);
    foodChowResponse.setImageURLList(getRandomFoodImageUrls());
    return foodChowResponse;
  }

  @Override
  public FoodChowResponse getSearchResults(FoodChowSearchRequest request) {
    List<Restaurant> restaurentsInTheNeighbourhood = getRestaurantsForZip(request.getZipcode());
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
    for (Image image : votedImages) {
      finalVector = addVectors(finalVector, image.getImageVector());
    }
    return finalVector;
  }

  private double[] addVectors(double[] finalVector, double[] imageVector) {
    for (int i = 0; i < finalVector.length - 1; i++) {
      finalVector[i] = finalVector[i] + imageVector[i];
    }
    return finalVector;
  }

  List<Image> mapRequestToSeletedImagesList(FoodChowSearchRequest request) {
    List<Image> images = new ArrayList<Image>();
    for (ImageObject imageObject : request.getImageResponses()) {
      for (Image image : selectedImages) {
        if (imageObject.getImageId().equals(image.getImageId())) {
          image.setVote(imageObject.getResponse());
          images.add(image);
        }
      }
    }
    return images;
  }

  private FoodChowResponse returnRecommendedRestaurants(List<Restaurant> restaurantsInTheNeighbourhood,
                                                        double[] normalizedImageVector) {
    List<Restaurant> restaurants = topRankRestaurants(normalizedImageVector,
        restaurantsInTheNeighbourhood);
    FoodChowResponse foodChowResponse = new FoodChowResponse();
    foodChowResponse.setRestaurants(restaurants);
    return foodChowResponse;
  }

  private double[] getNormalizedImageVector(double[] imageVector) {
    List<Double> vectorList = Arrays.asList(ArrayUtils.toObject(imageVector));
    double max = Collections.max(vectorList);
    double min = Collections.min(vectorList);
    if (Math.abs(min) > Math.abs(max)) {
      max = Math.abs(min);
    }
    for (int i = 0; i < imageVector.length; i++) {
      imageVector[i] = imageVector[i] / max;
    }
    return imageVector;
  }

  private List<Restaurant> getRestaurantsForZip(String zipCode) {
    YelpResponse yelpResponse = yelpClient.getRestaurants(zipCode);
    return yelpResponse.getRestaurants();
  }

  public List<Restaurant> topRankRestaurants(double[] imageResults, List<Restaurant> restaurants) {
    EuclideanDistance ed = new EuclideanDistance();
    for (Restaurant restaurant : restaurants) {
      double dist = ed.compute(imageResults, restaurant.getCategoryArray());
      restaurant.setDistance(dist);
    }
    return topResults(sortResults(restaurants));
  }

  public List<Restaurant> sortResults(List<Restaurant> restaurants) {
    Collections.sort(restaurants, new RestaurantSort());
    return restaurants;
  }

  public List<Restaurant> topResults(List<Restaurant> restaurants) {
    List<Restaurant> topResults = new ArrayList<Restaurant>();
    for (Restaurant rest : restaurants) {
      topResults.add(rest);
    }
    if (topResults != null & topResults.size() >= 5) { return topResults.subList(0, 5); } else {
      return defaultList();
    }
  }

  private List<Restaurant> defaultList() {
    List<Restaurant> restaurants = new ArrayList<Restaurant>();
    Restaurant restaurant1 = new Restaurant();
    restaurant1.setName(
        "Sorry! We couldn't find a restaurants you would like to eat in. We are awful. :(");
    restaurant1.setAvg_rating("5");
    restaurant1.setUrl("");
    return restaurants;
  }

}
