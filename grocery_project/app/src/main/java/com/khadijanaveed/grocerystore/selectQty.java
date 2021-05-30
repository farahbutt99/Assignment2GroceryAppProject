package com.khadijanaveed.grocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class selectQty extends AppCompatActivity {
    //Not Final Code ...Just to check
    TextView qty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_qty);

       qty= findViewById(R.id.QtyProductText);
       String rce="not know";
       Bundle extras =getIntent().getExtras();
       if(extras != null)
       {
           rce= extras.getString("rce");
       }
       qty.setText(rce);
    }
}