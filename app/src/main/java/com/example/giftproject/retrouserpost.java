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

    public void createUsers(){
        RegisterUsers registerUsers=new RegisterUsers(uname,uemail,upassword);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyJsonApi myJsonApi=retrofit.create(MyJsonApi.class);

        Call<RegisterUsers> call= myJsonApi.createUsers(registerUsers);

        call.enqueue(new Callback<RegisterUsers>() {
            @Override
            public void onResponse(Call<RegisterUsers> call, Response<RegisterUsers> response) {
                if(!response.isSuccessful()){
                    textviewresult.setText("Code: "+response.code());
                }
                RegisterUsers postResponse=response.body();

                String content="";
                content += "Code: "+response.code()+"\n";
                content += "ID: "+postResponse.getId()+"\n";
                content += "Name: "+postResponse.getName()+"\n";
                content += "Email: "+postResponse.getEmail()+"\n";
                content += "Password: "+postResponse.getPassword()+"\n";

                textviewresult.setText(content);
            }

            @Override
            public void onFailure(Call<RegisterUsers> call, Throwable t) {
                textviewresult.setText(t.getMessage());
            }
        });
    }
}