package com.example.giftproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MensclothGrid extends AppCompatActivity {

    ImageView cloth1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menscloth_grid);
        cloth1=findViewById(R.id.menc11);

        cloth1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),menscloth1.class);
                startActivity(i);
            }
        });


    }
}