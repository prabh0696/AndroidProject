package com.example.giftproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.giftproject.models.Product;

import java.util.ArrayList;
import java.util.List;

public class WomenShoes extends AppCompatActivity {

    List<Product> womenShoes ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_clothing);

        womenShoes = new ArrayList<>();
        womenShoes.add(new Product("79.99","Women Shoes","Description",R.drawable.womens1));
        womenShoes.add(new Product("89.99","Women Shoes","Description",R.drawable.womens2));
        womenShoes.add(new Product("45","Women Shoes","Description ",R.drawable.womens3));
        womenShoes.add(new Product("49","Women Shoes","Description ",R.drawable.womens4));
        womenShoes.add(new Product("76","Women Shoes","Description ",R.drawable.womens5));
        womenShoes.add(new Product("89.99","Women Shoes","Description ",R.drawable.womens6));
        womenShoes.add(new Product("99","Women Shoes","Description ",R.drawable.womens7));
        womenShoes.add(new Product("55","Women Shoes","Description ",R.drawable.womens8));
        womenShoes.add(new Product("120","Women Shoes","Description ",R.drawable.womens9));
        womenShoes.add(new Product("69","Women Shoes","Description ",R.drawable.womens10));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,womenShoes);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(myAdapter);
    }
}