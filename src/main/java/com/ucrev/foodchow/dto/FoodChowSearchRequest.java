package com.ucrev.foodchow.dto;

import java.util.ArrayList;
import java.util.List;

public class FoodChowSearchRequest {
    private Long guid;
    private List<ImageObject>  votedImages = new ArrayList<ImageObject>();

    public List<ImageObject> getVotedImages() {
        return votedImages;
    }

    public void setVotedImages(List<ImageObject> votedImages) {
        this.votedImages = votedImages;
    }

    public Long getGuid() {
        return guid;
    }

    public void setGuid(Long guid) {
        this.guid = guid;
    }
}
