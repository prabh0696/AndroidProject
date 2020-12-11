package com.example.giftproject.api_interfaces;

import com.example.giftproject.models.RegisterUsers;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MyJsonApi {

    @POST("users")
    Call<RegisterUsers> createUsers(@Body RegisterUsers registerUsers);
}
