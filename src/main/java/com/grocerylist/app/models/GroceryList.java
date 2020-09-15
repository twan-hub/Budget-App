package com.grocerylist.app.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class GroceryList extends AbstractEntity{

    private String location;

    private String category;

    private String name;

    private String item;

//    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<GroceryListItem> items= new ArrayList<>();

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public GroceryList(){
    }

    public GroceryList(String aName,String aLocation,String aCategory, String aItem){
        super();
        this.location=aLocation;
        this.category=aCategory;
        this.name=aName;
        this.item=aItem;
    }

//    public void addItem(GroceryListItem newItem){
//        items.add(newItem);
//    }


//    Getters and Setters


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

//    public List<GroceryListItem> getItems() {
//        return items;
//    }
//
//    public void setItems(List<GroceryListItem> items) {
//        this.items = items;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}


