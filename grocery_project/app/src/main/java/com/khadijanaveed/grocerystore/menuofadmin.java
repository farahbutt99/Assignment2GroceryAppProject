package com.khadijanaveed.grocerystore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class menuofadmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuofadmin);
    }
    public void viewuser(View view) {
        Intent intent = new Intent(this,viewuser.class);
        startActivity(intent);
    }

    public void addproduct(View view) {
        Intent intent = new Intent(this,addproduct.class);
        startActivity(intent);
    }

    public void deleteProductActivity(View view) {
        Intent intent = new Intent(this,deleteproduct.class);
        startActivity(intent);
    }
}