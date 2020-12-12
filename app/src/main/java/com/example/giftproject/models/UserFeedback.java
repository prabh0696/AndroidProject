package com.example.giftproject.models;

import com.google.gson.annotations.SerializedName;

public class UserFeedback {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String producttype;

    @SerializedName("feedback")
    private String userfeedback;

    public UserFeedback(String name, String email, String phone, String producttype, String userfeedback) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.producttype = producttype;
        this.userfeedback = userfeedback;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public String getUserfeedback() {
        return userfeedback;
    }

    public void setUserfeedback(String userfeedback) {
        this.userfeedback = userfeedback;
    }
}
