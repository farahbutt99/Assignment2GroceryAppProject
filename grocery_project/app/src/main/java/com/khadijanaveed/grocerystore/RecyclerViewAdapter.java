package com.khadijanaveed.grocerystore;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>
{
//    List<UserModel> usersList;
    ArrayList<UserModel> usersList;
    public RecyclerViewAdapter(ArrayList<UserModel> usersList)
    {
        this.usersList = usersList;
    }

@NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.recycleruserview, parent, false);
        return new MyViewHolder(itemView);
        }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.name.setText(usersList.get(position).getUserName());
        holder.email.setText(usersList.get(position).getEmailID());
        holder.phoneNo.setText(String.valueOf(usersList.get(position).getMobileNo()));
    }

    @Override
    public int getItemCount()
    {
        if(usersList.equals(null))
            return 0;
        return usersList.size();
    }

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView name, email,phoneNo;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.nameRUS);
        email = itemView.findViewById(R.id.emailRUS);
        phoneNo= itemView.findViewById(R.id.phoneNoRUS);
    }
}
}
