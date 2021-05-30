package com.khadijanaveed.grocerystore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class dairy extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyckerViewAdapterCategory adapterForRecycler;
    private RecyckerViewAdapterCategory.RecyclerViewClickListner listner;
    ArrayList<ProductModel> productsList= new ArrayList<ProductModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy);

        RecyclerView recyclerView=findViewById(R.id.RecyclerViewCatgeoryDairy);
        DbHelper db = new DbHelper(this);

        setOnClickListener();

        productsList = db.getProductsByCategory("Dairy");

        adapterForRecycler =new RecyckerViewAdapterCategory(productsList,listner);
        recyclerView.setAdapter(adapterForRecycler);
    }
    private void setOnClickListener()
    {

        listner=new RecyckerViewAdapterCategory.RecyclerViewClickListner()
        {
            @Override
            public void onClick(View v, int position)
            {
                Intent intent=new Intent(dairy.this,selectQty.class);
             //   intent.putExtra("rce",productsList.get(position).getProduct_Price());
                startActivity(intent);
            }
        };
    }
}