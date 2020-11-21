package com.example.giftproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.giftproject.models.Users;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

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
    FirebaseFirestore db;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetails);

        userEmail=findViewById(R.id.Email);
        userName=findViewById(R.id.Name);
        userPhone=findViewById(R.id.phone);
        userAddress=findViewById(R.id.apt);
        userCity=findViewById(R.id.city);
        userProvince=findViewById(R.id.province);
        userCountry=findViewById(R.id.country);
        userPostal=findViewById(R.id.postal);

        store_details=findViewById(R.id.storeBtn);

        skip_btn=findViewById(R.id.skipbtn);

        db=FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();

        Intent intent=getIntent();
        String aemail=intent.getStringExtra("userEmail");

        Toast.makeText(userdetails.this, "Email:"+aemail, Toast.LENGTH_LONG).show();
        userEmail.setText(aemail);

        store_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = userEmail.getText().toString().trim();
                String Name=userName.getText().toString();
                String phone=userPhone.getText().toString();
                String address=userAddress.getText().toString();
                String city=userCity.getText().toString();
                String province=userProvince.getText().toString();
                String country=userCountry.getText().toString();
                String postal=userPostal.getText().toString();
                addData(email,Name,phone,address,city,province,country,postal);
            }
        });

        skip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }

    public void addData(String uEmail,String uName,String uPhone,String uAddress,String uCity,
                        String uProvince,String uCountry,String uPostal){
        Users users=new Users(uEmail,uName,uPhone,uAddress,uCity,uProvince,uCountry,uPostal);
        userID=fAuth.getCurrentUser().getUid();
        db.collection("Users").document(userID).collection("UserData")
                .add(users)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        Toast.makeText(getApplicationContext(), "User Details Saved", Toast.LENGTH_LONG).show();
                        startActivity(i);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error:"+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}