package com.khadijanaveed.grocerystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText t1,t2,t3,t4;
    UserModel user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        t1 = findViewById(R.id.mail);
        t2 = findViewById(R.id.username);
        t3 = findViewById(R.id.password);
        t4 = findViewById(R.id.number);
    }

    public void login(View view) {
        Intent intent = new Intent(signup.this,login.class);
        startActivity(intent);
    }
    //Create a new user
    public void Signup(View view) {
//        user=new UserModel(
//                t1.getText().toString(),
//                t2.getText().toString(),
//                t3.getText().toString(),
//                Long.parseLong(t4.getText().toString()), "Admin");
        user=new UserModel(
                t1.getText().toString(),
                t2.getText().toString(),
                t3.getText().toString(),
                Long.parseLong(t4.getText().toString()), "Customer");
        DbHelper db = new DbHelper(this);
        String result = db.addUser(user);
        Toast.makeText(this,result,Toast.LENGTH_LONG).show();

        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");

        Intent intent = new Intent(signup.this,login.class);
        startActivity(intent);
    }
}