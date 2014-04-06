package com.ucrev.foodchow.dto;


import java.util.List;

public class CategoryMap {
   private  List<String>  categories;

    public CategoryMap() {
       String[] categories = {"bagels","bakeries","bubbletea","butcher","coffee","desserts","donuts","icecream","pretzels","gourmet","chocolate"};
       for(String s:categories){
           this.categories.add(s);
       }
    }

    public List<String> getCategories() {
        return categories;
    }

}
