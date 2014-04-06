package com.ucrev.foodchow.dto;

public class Category {
    private String category_filter;
    private String name;
    private String search_url;


    public String getCategory_filter() {
        return category_filter;
    }

    public void setCategory_filter(String category_filter) {
        this.category_filter = category_filter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSearch_url() {
        return search_url;
    }

    public void setSearch_url(String search_url) {
        this.search_url = search_url;
    }
}
