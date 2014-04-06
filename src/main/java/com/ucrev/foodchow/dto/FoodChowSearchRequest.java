package com.ucrev.foodchow.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodChowSearchRequest {
    private Long guid;
    private List<ImageObject> imageResponses = new ArrayList<ImageObject>();
    private String zipcode;

    public String getZipcode() {return zipcode; }

    public void setZipcode(String zipcode) { this.zipcode = zipcode;}

    public List<ImageObject> getImageResponses() {
        return imageResponses;
    }

    public void setImageResponses(List<ImageObject> imageResponses) {
        this.imageResponses = imageResponses;
    }

    public Long getGuid() {
        return guid;
    }

    public void setGuid(Long guid) {
        this.guid = guid;
    }
}
