package com.example.giftproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminMainPage extends AppCompatActivity {

    Button profile_btn;
    Button feedback_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main_page);

        profile_btn=findViewById(R.id.showprofile_btn);
        feedback_btn=findViewById(R.id.showfeedback_btn);

        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),RetroProfilePost.class);
                startActivity(intent);
            }
        });

        feedback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),RetrofitFeedbackShow.class);
                startActivity(intent);
            }
        });
    }
}