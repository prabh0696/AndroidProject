package com.example.giftproject.models;

public class Product {
    private String Price ;
    private String Category ;
    private String Description;
    private int Image ;

    public Product() { }

    public Product(String price, String category, String description, int image) {
        Price = price;
        Category = category;
        Description = description;
        Image = image;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
