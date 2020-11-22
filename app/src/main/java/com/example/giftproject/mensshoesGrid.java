package com.example.giftproject;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class mensshoesGrid extends AppCompatActivity {

    ImageView shoe1;
    ImageView shoe2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensshoes_grid);
        shoe1=findViewById(R.id.mensh4);
        shoe2=findViewById(R.id.mensh5);

        shoe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),mensshoes1.class);
                startActivity(i);
            }
        });

        shoe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),mensshoes2.class);
                startActivity(i);
            }
        });

    }


}