package com.example.giftproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class mensshoesGrid extends AppCompatActivity {
    GridLayout mainGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensshoes_grid);


    }

    private void setSingleEvent(GridLayout mainGrid) {

        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int itemID = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemID == 2)
                    {
                        Intent intent = new Intent(mensshoesGrid.this,mensshoes2.class);
                        startActivity(intent);

                    }else if(itemID == 5)
                    {
                        Intent intent = new Intent(mensshoesGrid.this,mensshoes1.class);
                        startActivity(intent);

                    }
                    else{
                        Toast.makeText(mensshoesGrid.this, "activity is not set for this item", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
}