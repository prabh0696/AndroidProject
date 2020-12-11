package com.example.giftproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginType extends AppCompatActivity {

    Button userlogin_btn;
    Button adminlogin_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_type);
        userlogin_btn=findViewById(R.id.UserLogin);
        adminlogin_btn=findViewById(R.id.AdminLogin);

        userlogin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),SignUp.class);
                startActivity(i);
            }
        });
    }
}