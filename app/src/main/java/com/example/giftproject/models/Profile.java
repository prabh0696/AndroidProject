package com.example.giftproject.models;

import com.google.gson.annotations.SerializedName;

public class Profile {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String city;
    private String province;
    private String country;
    private String postalcode;

    @SerializedName("address")
    private String useraddress;

    public Profile(String name, String email, String phone, String city, String province, String country, String postalcode, String useraddress) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalcode = postalcode;
        this.useraddress = useraddress;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }
}
