package com.example.giftproject;

import android.os.Bundle;

import com.example.giftproject.models.Product;

import java.util.ArrayList;
import java.util.List;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MensClothes extends AppCompatActivity {

    List<Product> menClothing ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_activity);

        menClothing = new ArrayList<>();
        menClothing.add(new Product("79.99","Men Clothing","Description",R.drawable.clothgrid1));
        menClothing.add(new Product("99","Men Clothing","Description",R.drawable.clothgrid2));
        menClothing.add(new Product("139.99","Men Clothing","Description ",R.drawable.clothgrid3));
        menClothing.add(new Product("89.59","Men Clothing","Description ",R.drawable.clothgrid4));
        menClothing.add(new Product("59","Men Clothing","Description ",R.drawable.clothgrid5));
        menClothing.add(new Product("76","Men Clothing","Description ",R.drawable.clothgrid6));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,menClothing);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(myAdapter);
    }
}
