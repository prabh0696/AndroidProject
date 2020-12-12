package com.example.giftproject;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giftproject.api_interfaces.MyJsonApi;
import com.example.giftproject.models.Profile;

public class RetrofitProfileInsert extends AppCompatActivity {
    TextView textviewresult;
    TextView home_link;
    String name;
    String email;
    String phone;
    String address;
    String city;
    String province;
    String country;
    String postalcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_profile_insert);

        textviewresult=findViewById(R.id.text_view_result);
        home_link=findViewById(R.id.homepage);

        Intent intent=getIntent();
        name=intent.getStringExtra("uname");
        email=intent.getStringExtra("uemail");
        phone=intent.getStringExtra("uphone");
        address=intent.getStringExtra("uaddress");
        city=intent.getStringExtra("ucity");
        province=intent.getStringExtra("uprovince");
        country=intent.getStringExtra("ucountry");
        postalcode=intent.getStringExtra("upostal");

        createProfiles();

        home_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void createProfiles(){
        Profile profile=new Profile(name,email,phone,address,city,province,country,postalcode);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyJsonApi myJsonApi=retrofit.create(MyJsonApi.class);

        Call<Profile> call=myJsonApi.createProfiles(profile);

        String content="";
        content += "Name: "+name+"\n";
        content += "Email: "+email+"\n";
        content += "Phone: "+phone+"\n";
        content += "Address: "+address+"\n";
        content += "City: "+city+"\n";
        content += "Province: "+province+"\n";
        content += "Country: "+country+"\n";
        content += "PostalCode: "+postalcode+"\n\n";

        textviewresult.setText(content);

        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if(!response.isSuccessful()){
                    textviewresult.setText("Code: "+response.code());
                }

                Profile postResponse=response.body();

            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                Toast.makeText(RetrofitProfileInsert.this, ".", Toast.LENGTH_SHORT).show();
            }
        });
    }
}