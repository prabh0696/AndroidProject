package com.example.giftproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.giftproject.models.Product;

import java.util.ArrayList;
import java.util.List;

public class WomenClothing extends AppCompatActivity {

    List<Product> womenClothing ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_clothing);



        womenClothing = new ArrayList<>();
        womenClothing.add(new Product("79.99","Women Clothing","Description",R.drawable.womenc1));
        womenClothing.add(new Product("99","Women Clothing","Description",R.drawable.womenc2));
        womenClothing.add(new Product("139.99","Women Clothing","Description ",R.drawable.womenc3));
        womenClothing.add(new Product("89.59","Women Clothing","Description ",R.drawable.womenc4));
        womenClothing.add(new Product("59","Women Clothing","Description ",R.drawable.womenc5));
        womenClothing.add(new Product("76","Women Clothing","Description ",R.drawable.womenc6));
        womenClothing.add(new Product("79.99","Women Clothing","Description ",R.drawable.womenc7));
        womenClothing.add(new Product("55.99","Women Clothing","Description ",R.drawable.womenc8));
        womenClothing.add(new Product("45.89","Women Clothing","Description ",R.drawable.womenc9));
        womenClothing.add(new Product("89.99","Women Clothing","Description ",R.drawable.womenc10));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,womenClothing);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(myAdapter);
    }
}