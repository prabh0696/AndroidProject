package com.example.giftproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class userdetails extends AppCompatActivity {
    private static final String TAG = "TAG";
    EditText userEmail;
    EditText userName;
    EditText userPhone;
    EditText userAddress;
    EditText userCity;
    EditText userProvince;
    EditText userCountry;
    EditText userPostal;
    Button store_details;
    TextView skip_btn;
    String userID;

    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetails);
    }
}