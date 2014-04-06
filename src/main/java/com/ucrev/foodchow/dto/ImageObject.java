package com.ucrev.foodchow.dto;

public class ImageObject {
    private String imageURL;
    private int response;

    public String getImageId() {
        return imageURL;
    }

    public void setImageId(String imageId) {
        this.imageURL = imageId;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }
}
