package com.example.giftproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.giftproject.models.Product;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context mContext ;
    private List<Product> mData ;


    public RecyclerViewAdapter(Context mContext, List<Product> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_products,parent,false);
        return new MyViewHolder(view);      }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.PriceDetail.setText(mData.get(position).getPrice());
        holder.ImageDetail.setImageResource(mData.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, ProductItemDescription.class);

                intent.putExtra("Price",mData.get(position).getPrice());
                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Category",mData.get(position).getCategory());
                intent.putExtra("Image",mData.get(position).getImage());
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView PriceDetail;
        ImageView ImageDetail;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            PriceDetail = (TextView) itemView.findViewById(R.id.Price_detail) ;
            ImageDetail = (ImageView) itemView.findViewById(R.id.Image_detail);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
    }
}
}
