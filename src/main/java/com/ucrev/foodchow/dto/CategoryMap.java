package com.ucrev.foodchow.dto;


import java.util.List;

public class CategoryMap {
   private  List<String>  categories;

    public CategoryMap() {
       String[] categories = {"bagels","bakeries","beer_and_wine","breweries","bubblete","butcher","coffee","cupcakes","desserts","distilleries","diyfood","donuts","gelato","icecream","juicebars","pretzels","shavedice","gourmet","candy","chocolate","tea","wineries"};
       for(String s:categories){
           this.categories.add(s);
       }
    }

    public List<String> getCategories() {
        return categories;
    }

}
