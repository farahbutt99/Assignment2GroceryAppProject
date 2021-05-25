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

    Button button;
    EditText deleteProdName;
    DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuofadmin);
        button = findViewById(R.id.deleteproduct);
//        deleteProdName= findViewById(R.id.productname);
//      //  String prod_name=deleteProdName.getText().toString();
//        db =new DbHelper(this);
    }

    public void viewuser(View view) {
        Intent intent = new Intent(this,viewuser.class);
        startActivity(intent);
    }

    public void addproduct(View view) {
        Intent intent = new Intent(this,addproduct.class);
        startActivity(intent);
    }

    public void dialoguedel(View view) {
        Intent intent = new Intent(this,deleteproduct.class);
        startActivity(intent);
        //        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Delete Product");
//        builder.setCancelable(false);
//        LayoutInflater inflater = this.getLayoutInflater();
//        builder.setView(inflater.inflate(R.layout.activity_deleteproduct,null));
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
    }

//    public void deleteProductbtn(View view) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage("Are you sure you want to delete");
//        builder.setTitle("Delete Product");
//        builder.setCancelable(false);
//
//        builder.setPositiveButton("Yes",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        String result  = db.deleteProduct(deleteProdName.getText().toString());
//                        Toast.makeText(menuofadmin.this,result,Toast.LENGTH_LONG).show();
//                    }
//                }
//        );
//        builder.setNegativeButton("No",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(menuofadmin.this, "Not Deleted", Toast.LENGTH_LONG).show();
//                    }
//                }
//        );
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }
}