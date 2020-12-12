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
import com.example.giftproject.models.UserFeedback;
import com.google.firebase.firestore.auth.User;

public class RetrofitFeedbackInsert extends AppCompatActivity {

    TextView textviewresult;
    TextView home_link;
    String name;
    String email;
    String phone;
    String product;
    String feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_feedback_insert);

        textviewresult=findViewById(R.id.text_view_result);
        home_link=findViewById(R.id.homepage);

        Intent intent=getIntent();
        name=intent.getStringExtra("fname");
        email=intent.getStringExtra("femail");
        phone=intent.getStringExtra("fphone");
        product=intent.getStringExtra("fproduct");
        feedback=intent.getStringExtra("ffeedback");

        createFeedbacks();

        home_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void createFeedbacks(){
        UserFeedback userFeedback=new UserFeedback(name,email,phone,product,feedback);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyJsonApi myJsonApi=retrofit.create(MyJsonApi.class);

        Call<UserFeedback> call=myJsonApi.createFeedbacks(userFeedback);

        String content="";
        content += "Name: "+name+"\n";
        content += "Email: "+email+"\n";
        content += "Phone: "+phone+"\n";
        content += "Product Type: "+product+"\n";
        content += "Feedback: "+feedback+"\n\n";

        textviewresult.setText(content);

        call.enqueue(new Callback<UserFeedback>() {
            @Override
            public void onResponse(Call<UserFeedback> call, Response<UserFeedback> response) {
                if(!response.isSuccessful()){
                    textviewresult.setText("Code: "+response.code());
                }

                UserFeedback postResponse=response.body();
            }

            @Override
            public void onFailure(Call<UserFeedback> call, Throwable t) {
                Toast.makeText(RetrofitFeedbackInsert.this, ".", Toast.LENGTH_SHORT).show();
            }
        });
    }
}