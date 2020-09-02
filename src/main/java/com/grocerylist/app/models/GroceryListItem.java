package com.grocerylist.app.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
public class GroceryListItem extends AbstractEntity{


    private String name;

    private int quantity;

    public GroceryListItem(){

    }

    public GroceryListItem(String name, int quantity) {
        super();
        this.name=name;
        this.quantity=quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
