package com.ucrev.foodchow.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

public class Restaurant {
    private String url;
    private String name;
    private String rating_img_url;
    private String country_code;
    private String is_closed;
    private String city;
    private String mobile_url;
    private int review_count;
    private String zip;
    private String address1;
    private String address2;
    private String address3;
    private String phone;
    private String state_code;
    private String avg_rating;
    List<Category> categories;
    private double distance;
    private double[] categoryArray;
    private String info;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = avg_rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryArray(double[] categoryArray) {
        this.categoryArray = categoryArray;
    }

    public String getRating_img_url() {
        return rating_img_url;
    }

    public void setRating_img_url(String rating_img_url) {
        this.rating_img_url = rating_img_url;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getIs_closed() {
        return is_closed;
    }

    public void setIs_closed(String is_closed) {
        this.is_closed = is_closed;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getAvg_rating() {
        return avg_rating;
    }

    public void setAvg_rating(String avg_rating) {
        this.avg_rating = avg_rating;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double[] getCategoryArray() {
        double[] categoriesForRestaurant={0};
        CategoryMap map = new CategoryMap();
        for(Category cat:this.categories) {
            if(map.getCategories().contains(cat.getCategory_filter())){
                categoriesForRestaurant[map.getCategories().indexOf(cat.getCategory_filter())]=1;
            }
        }
        return categoryArray;
    }

}
