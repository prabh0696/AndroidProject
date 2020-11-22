package com.example.giftproject.models;

public class Feedbacks {
    String Email;
    String Name;
    String Phone;
    String Product;
    String Query;

    public Feedbacks(String email, String name, String phone, String product, String query) {
        Email = email;
        Name = name;
        Phone = phone;
        Product = product;
        Query = query;
    }

    public Feedbacks(){}

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getQuery() {
        return Query;
    }

    public void setQuery(String query) {
        Query = query;
    }
}
