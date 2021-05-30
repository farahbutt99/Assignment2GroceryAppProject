package com.khadijanaveed.grocerystore;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyckerViewAdapterCategory extends RecyclerView.Adapter<RecyckerViewAdapterCategory.MyViewHolder>
{
    ArrayList<ProductModel> productsList;
    private RecyclerViewClickListner listner;

    public RecyckerViewAdapterCategory(ArrayList<ProductModel> productsList,RecyclerViewClickListner listner)
    {
        this.productsList = productsList;
        this.listner=listner;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerlayout_products, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.price.setText(productsList.get(position).getProduct_Price().toString());
        holder.imgofproduct.setImageBitmap(productsList.get(position).getProduct_Image());
    }

    @Override
    public int getItemCount()
    {
        if(productsList.equals(null))
           return 0;
       return productsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView price, stockQty,qty;
        ImageView imgofproduct;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.priceProductText);
            imgofproduct = itemView.findViewById(R.id.imageProduct);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listner.onClick(v,getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListner
    {
        void onClick(View v,int position);
    }
}