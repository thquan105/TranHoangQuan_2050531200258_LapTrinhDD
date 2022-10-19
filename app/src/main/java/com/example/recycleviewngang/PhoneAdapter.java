package com.example.recycleviewngang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.PhoneViewHolderc>{

    ArrayList<Phone> dataPhones;

    public void setData(ArrayList<Phone> dataPhones) {
        this.dataPhones = dataPhones;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public PhoneViewHolderc onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_phone,parent,false);
        return new PhoneViewHolderc(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHolderc holder, int position) {
        Phone phone = dataPhones.get(position);
        if (phone == null){
            return;
        }

        holder.txtName.setText(phone.getName_phone());
        holder.txtPrice.setText(phone.getPrice_phone());
        holder.imgPhone.setImageResource(phone.getImage_phone());
    }

    @Override
    public int getItemCount() {
        if (dataPhones != null) {
            return dataPhones.size();
        }
        return 0;
    }

    public class PhoneViewHolderc extends RecyclerView.ViewHolder{

        private ImageView imgPhone;
        private TextView txtName;
        private TextView txtPrice;

        public PhoneViewHolderc(@NonNull View itemView) {
            super(itemView);

            imgPhone = itemView.findViewById(R.id.img_phone);
            txtName = itemView.findViewById(R.id.txt_ten);
            txtPrice = itemView.findViewById(R.id.txt_gia);
        }
    }
}
