package com.ucrev.foodchow.dto;

public class Image {
    private String imageId;
    private double[] imageVector;
    private int vote;
    private boolean selected;

    public Image(String imageId,double[] vector,int vote,boolean selected){
        this.imageId = imageId;
        this.imageVector = vector;
        this.vote = vote;
        this.selected = selected;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public double[] getImageVector() {
        return imageVector;
    }

    public void setImageVector(double[] imageVector) {
        this.imageVector = imageVector;
    }

   void addVoteToVector(){
        for(int i =0;i<imageVector.length;i++){
            imageVector[i] = imageVector[i] + Double.parseDouble(String.valueOf(vote));
        }
    }
}
