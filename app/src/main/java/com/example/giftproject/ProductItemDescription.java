package com.example.giftproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductItemDescription extends AppCompatActivity {

    private TextView price,description,category;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_item_description);


        price = (TextView) findViewById(R.id.Price);
        description = (TextView) findViewById(R.id.Desc);
        category = (TextView) findViewById(R.id.Category);
        img = (ImageView) findViewById(R.id.Image);

        Intent intent = getIntent();
        String Price = intent.getExtras().getString("Price");
        String Description = intent.getExtras().getString("Description");
        String Category = intent.getExtras().getString("Category");
        int image = intent.getExtras().getInt("Image") ;


        price.setText(Price);
        category.setText(Category);
        description.setText(Description);
        img.setImageResource(image);
    }
}