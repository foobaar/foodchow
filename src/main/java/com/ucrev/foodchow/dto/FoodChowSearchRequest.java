package com.ucrev.foodchow.dto;

import java.util.ArrayList;
import java.util.List;

public class FoodChowSearchRequest {
    private Long guid;
    private List<ImageObject> imageResponses = new ArrayList<ImageObject>();

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
