package com.example.bookstore.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L; //
    private String name;
    private String price;
    private Integer quantity;
    private String description;

    public Product(String name, String price, int quantity, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
