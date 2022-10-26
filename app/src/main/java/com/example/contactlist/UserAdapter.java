package com.example.contactlist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHoder>{
    ArrayList<User> dataUser;
    Context context;

    public UserAdapter(ArrayList<User> dataUser, Context context) {
        this.dataUser = dataUser;
        this.context = context;
    }

    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row,parent,false);
        return new ViewHoder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHoder holder, int position) {
        User user = dataUser.get(position);
        if (user == null){
            return;
        }
        holder.txtName.setText(user.getTen());
        holder.txtNum.setText(user.getSo());

        holder.mainCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Name", user.getTen());
                intent.putExtra("Number", user.getSo());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataUser.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder{
        TextView txtName, txtNum;
        CardView mainCard;
        public ViewHoder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txt_Name);
            txtNum = (TextView) itemView.findViewById(R.id.txt_Number);
            mainCard = itemView.findViewById(R.id.main_card);
        }
    }
}
