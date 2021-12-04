package com.example.bookstore.models;

public class ItemOrderModel {
    private int Img;
    private String nameBook;
    private int Price, numberOfProduct;

    public ItemOrderModel(int img, String nameBook, int price) {
        Img = img;
        this.nameBook = nameBook;
        Price = price;
        this.numberOfProduct = 0;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }
}
