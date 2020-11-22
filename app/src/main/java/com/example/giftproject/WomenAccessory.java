package com.example.giftproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.giftproject.models.Product;

import java.util.ArrayList;
import java.util.List;

public class WomenAccessory extends AppCompatActivity {

    List<Product> womenAccessory ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_clothing);
        womenAccessory = new ArrayList<>();
        womenAccessory.add(new Product("120","Women Accessory","Description",R.drawable.womena1));
        womenAccessory.add(new Product("150","Women Accessory","Description",R.drawable.womena2));
        womenAccessory.add(new Product("95.99","Women Accessory","Description ",R.drawable.womena3));
        womenAccessory.add(new Product("79","Women Accessory","Description ",R.drawable.womena4));
        womenAccessory.add(new Product("56.29","Women Accessory","Description ",R.drawable.womena5));
        womenAccessory.add(new Product("89.99","Women Accessory","Description ",R.drawable.womena6));
        womenAccessory.add(new Product("11.99","Women Accessory","Description ",R.drawable.womena7));
        womenAccessory.add(new Product("59","Women Accessory","Description ",R.drawable.womena8));
        womenAccessory.add(new Product("47","Women Accessory","Description ",R.drawable.womena9));
        womenAccessory.add(new Product("15.99","Women Accessory","Description ",R.drawable.womena10));
        womenAccessory.add(new Product("78.89","Women Accessory","Description ",R.drawable.womena11));
        womenAccessory.add(new Product("99","Women Accessory","Description ",R.drawable.womena12));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,womenAccessory);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(myAdapter);
    }
}