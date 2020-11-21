package com.example.giftproject.models;

public class Users {
    String uEmail;
    String uName;
    String uPhone;
    String uAddress;
    String uCity;
    String uProvince;
    String uCountry;
    String uPostal;

    public Users(String uEmail, String uName, String uPhone, String uAddress, String uCity, String uProvince, String uCountry, String uPostal) {
        this.uEmail = uEmail;
        this.uName = uName;
        this.uPhone = uPhone;
        this.uAddress = uAddress;
        this.uCity = uCity;
        this.uProvince = uProvince;
        this.uCountry = uCountry;
        this.uPostal = uPostal;
    }

    public Users(){}

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getuCity() {
        return uCity;
    }

    public void setuCity(String uCity) {
        this.uCity = uCity;
    }

    public String getuProvince() {
        return uProvince;
    }

    public void setuProvince(String uProvince) {
        this.uProvince = uProvince;
    }

    public String getuCountry() {
        return uCountry;
    }

    public void setuCountry(String uCountry) {
        this.uCountry = uCountry;
    }

    public String getuPostal() {
        return uPostal;
    }

    public void setuPostal(String uPostal) {
        this.uPostal = uPostal;
    }
}
