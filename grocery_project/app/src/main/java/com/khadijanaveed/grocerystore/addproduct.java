package com.khadijanaveed.grocerystore;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class addproduct extends AppCompatActivity {
    EditText p_name,p_price,p_qty;
    ImageView imageView;
    Uri ImageFilePath;
    Bitmap ImageToStore;
    Button button;
    private static final int PICK_IMAGE_REQUEST=100;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproduct);
        imageView = findViewById(R.id.addimage);
        p_name = findViewById(R.id.productname);
        p_price = findViewById(R.id.price);
        p_qty = findViewById(R.id.quantity);
        button = findViewById(R.id.add);
        db =new DbHelper(this);
    }
// it is used to choose image from gallery
    public void chooseimage(View view) {
        Intent intent = new Intent().setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);
    }

//    it is used to show choosen image on imageview
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            ImageFilePath = data.getData();
            try {
                ImageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(),ImageFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageView.setImageBitmap(ImageToStore);
        }
    }

    public void AddProductDialog(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to add the product?");
        builder.setTitle("Add Product");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String prod_name=p_name.getText().toString();
                        String prod_Catgry="Fruits";
                        Double prod_Qty=Double.parseDouble(p_qty.getText().toString());
                        Double prod_price=Double.parseDouble(p_price.getText().toString());
                        ProductModel productModel  = new ProductModel(
                                prod_name,
                                "Fruits",
                                prod_Qty,
                                prod_price,
                                ImageToStore
                        );
                        productModel.setProduct_Category(prod_Catgry);
                        String result  = db.addProduct(productModel);
                        p_name.setText("");
                        p_price.setText("");
                        p_qty.setText("");
                        Toast.makeText(addproduct.this,result,Toast.LENGTH_LONG).show();
                    }
                }
        );
        builder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(addproduct.this, "Not added", Toast.LENGTH_LONG).show();
                    }
                }
        );
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}