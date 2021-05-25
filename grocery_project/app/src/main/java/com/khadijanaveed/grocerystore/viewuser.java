package com.khadijanaveed.grocerystore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class viewuser extends AppCompatActivity {
//    List<UserModel> allUsers;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapterForRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewuser);

        RecyclerView recyclerView=findViewById(R.id.recycleruser);
        DbHelper db = new DbHelper(this);
        ArrayList<UserModel> allUsers= new ArrayList<UserModel>();
        allUsers = db.getAllRecords();

        adapterForRecycler =new RecyclerViewAdapter(allUsers);
        recyclerView.setAdapter(adapterForRecycler);
    }
}