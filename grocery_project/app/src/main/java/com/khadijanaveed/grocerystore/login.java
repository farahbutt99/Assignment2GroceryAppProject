package com.khadijanaveed.grocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText t1, t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = findViewById(R.id.signup);
        setContentView(R.layout.activity_login);
        t1 = findViewById(R.id.username);
        t2 = findViewById(R.id.password);
    }

    public void signup(View view) {
        new DbHelper(this);
        Intent intent = new Intent(login.this,signup.class);
        startActivity(intent);
    }

    public void homeProceedAnyway(View view) {
        Intent intent = new Intent(login.this,home.class);
        startActivity(intent);
    }

    public void adminsideOrCustomerside(View view) {
        DbHelper db = new DbHelper(this);
        String usrName=t1.getText().toString();
        String pswd=t2.getText().toString();

        UserModel user= db.getUser(usrName,pswd);
        if(user != null)
        {
           // Toast.makeText(this,user.getUserType(),Toast.LENGTH_LONG).show();
            if(user.getUserType().equals("Admin"))
            {
                Intent intent = new Intent(login.this,menuofadmin.class);
                startActivity(intent);
            }
            else if(user.getUserType().equals("Customer"))
            {
                 Intent intent = new Intent(login.this,home.class);
                 startActivity(intent);
            }
            else
            {
                Toast.makeText(this,"Not KNOWN",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this,"Not FOund",Toast.LENGTH_LONG).show();
        }


    }
}