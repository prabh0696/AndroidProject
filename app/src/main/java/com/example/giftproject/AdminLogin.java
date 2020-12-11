package com.example.giftproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class AdminLogin extends AppCompatActivity {
    EditText Email,Password;
    Button Login;
    TextView link;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);

        Login =findViewById(R.id.SignIn);
        link = findViewById(R.id.signuplink);
        progressBar = findViewById(R.id.progressBar);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if(TextUtils.isEmpty(email)){

                    Email.setError("Email is required");
                    return;

                }
                if(TextUtils.isEmpty(password)){

                    Password.setError("Password is required");
                    return;

                }
                progressBar.setVisibility(View.VISIBLE);
                if(email=="admin1@gmail.com" && password =="admin"){
                    Toast.makeText(AdminLogin.this,"Sign In Successfully",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),loginType.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(AdminLogin.this,"Email or Password is incorrect",Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }

            }
        });
    }
}