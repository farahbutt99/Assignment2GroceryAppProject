package com.khadijanaveed.grocerystore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class deleteproduct extends AppCompatActivity {
    EditText deleteProdName;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteproduct);
        deleteProdName= findViewById(R.id.productname);
        db =new DbHelper(this);
    }

    public void deleteProductbtn(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to delete");
        builder.setTitle("Delete Product");
        builder.setCancelable(false);

        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result  = db.deleteProduct(deleteProdName.getText().toString());
                        deleteProdName.setText("");
                        Toast.makeText(deleteproduct.this,result,Toast.LENGTH_LONG).show();
                    }
                }
        );
        builder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(deleteproduct.this, "Not Deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}