package com.example.giftproject;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.giftproject.api_interfaces.MyJsonApi;
import com.example.giftproject.models.RegisterUsers;

public class retrouserpost extends AppCompatActivity {

    TextView textviewresult;
    String uname;
    String uemail;
    String upassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrouserpost);

        textviewresult=findViewById(R.id.text_view_result);
        Intent intent=getIntent();
        uname=intent.getStringExtra("userName");
        uemail=intent.getStringExtra("userEmail");
        upassword=intent.getStringExtra("userPassword");
        //createUsers();
    }


}