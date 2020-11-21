package com.example.giftproject;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    EditText Email,Password;
    Button Login;
    TextView link;
    FirebaseAuth auth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);

        Login =findViewById(R.id.SignIn);
        link = findViewById(R.id.signuplink);
        progressBar = findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();

        Login.setOnClickListener(v -> {
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

            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(LoginPage.this,"Sign In Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),userdetails.class);
                    intent.putExtra("userEmail",email);
                    startActivity(intent);

                }else {
                    Toast.makeText(LoginPage.this,"Error!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);

                }
            });
        });




        link.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),SignUp.class)));
    }
}