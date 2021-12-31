package com.example.bookstore.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ProductModel implements Serializable {
    private static final long serialVersionUID = 1L; //
    private String name;
    private String price;
    private int priceTmp;
    private Integer quantity;
    private String description;
    private int Img;

    public ProductModel(String name, String price, int quantity, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.priceTmp = Integer.valueOf(price);
    }

    public ProductModel(int img, String name, int priceTmp, Integer quantity, String description) {
        this.name = name;
        this.priceTmp = priceTmp;
        this.price = String.valueOf(priceTmp);
        this.quantity = quantity;
        this.description = description;
        Img = img;
    }

    public int getImg() {
        return Img;
    }

    public String getName() {
        return name;
    }

    public int getPriceTmp(){return priceTmp;}

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
