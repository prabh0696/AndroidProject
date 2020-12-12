package com.example.giftproject;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.TextView;

import com.example.giftproject.api_interfaces.MyJsonApi;
import com.example.giftproject.models.Profile;

import java.util.List;

public class RetroProfilePost extends AppCompatActivity {
    TextView textviewresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retro_profile_post);

        textviewresult=findViewById(R.id.text_view_result);

        getProfiles();
    }

    public void getProfiles(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyJsonApi myJsonApi=retrofit.create(MyJsonApi.class);
        Call<List<Profile>> call=myJsonApi.getProfiles();

        call.enqueue(new Callback<List<Profile>>() {
            @Override
            public void onResponse(Call<List<Profile>> call, Response<List<Profile>> response) {

                if(!response.isSuccessful()){
                    textviewresult.setText("Code: "+response.code());
                }

                List<Profile> profiles=response.body();
                for(Profile profile:profiles){
                    String content="";
                    content += "ID: "+profile.getId()+"\n";
                    content += "Name: "+profile.getName()+"\n";
                    content += "Email: "+profile.getEmail()+"\n";
                    content += "Phone: "+profile.getPhone()+"\n";
                    content += "Address: "+profile.getUseraddress()+"\n";
                    content += "City: "+profile.getCity()+"\n";
                    content += "Province: "+profile.getProvince()+"\n";
                    content += "Country: "+profile.getCountry()+"\n";
                    content += "Postal: "+profile.getPostalcode()+"\n\n";

                    textviewresult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Profile>> call, Throwable t) {
                textviewresult.setText(t.getMessage());
            }
        });
    }
}