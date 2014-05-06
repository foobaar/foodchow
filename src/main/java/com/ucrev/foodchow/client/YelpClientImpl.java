package com.ucrev.foodchow.client;

import com.google.gson.Gson;
import com.ucrev.foodchow.dto.YelpResponse;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class YelpClientImpl implements YelpClient {

  private static String YELP_BASE_URL = "http://api.yelp.com/business_review_search?";

  protected RestTemplate restTemplate = new RestTemplate();
  private Gson gson = new Gson();

  @Override
  public YelpResponse getRestaurants(String zipcode) {
    /*
    http.proxyHost=cdcwebinet-a.kroger.com
    http.proxyPort=3128
    http.proxyUser=SVCFMJMAPQUEST
    http.proxyPassword=xldow83Diek93qk
     */

    //setting kroger proxy
    /*
    System.getProperties().put("http.proxyHost", "cdcwebinet-a.kroger.com");
    System.getProperties().put("http.proxyPort", "3128");
    System.getProperties().put("http.proxyUser", "SVCFMJMAPQUEST");
    System.getProperties().put("http.proxyPassword", "xldow83Diek93qk");
     */
    String yelpResponse = restTemplate.getForObject(YELP_BASE_URL+"term=food&offset=20&location="+zipcode+"i&limit=50&ywsid=GkEt7fj69eNfI-n7Bv3BPQ",String.class);
    return gson.fromJson(yelpResponse,YelpResponse.class);
  }

  @Test
  public void testGetRestaurents() {
    YelpResponse restaurants = getRestaurants("45220");
    System.out.println(restaurants.getRestaurants().size());
  }
}
