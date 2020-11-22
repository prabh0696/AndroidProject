package com.example.giftproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    EditText Name,Email,Password;
    Button register;
    TextView link;
    FirebaseAuth auth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Name = findViewById(R.id.Name);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);

        register = findViewById(R.id.SignUp);

        link = findViewById(R.id.LoginLink);
        progressBar = findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();



        register.setOnClickListener(v -> {
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
            if(password.length()<6){

                Password.setError("Password must contain six characters");
                return;

            }
           progressBar.setVisibility(View.VISIBLE);

            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {

                if(task.isSuccessful()){
                    Toast.makeText(SignUp.this,"Sign Up successfully",Toast.LENGTH_LONG).show();

                    startActivity(new Intent(getApplicationContext(),LoginPage.class));
                }else {
                    Toast.makeText(SignUp.this,"Error!"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);

                }
            });

        });


        link.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), LoginPage.class));
        });

    }
}