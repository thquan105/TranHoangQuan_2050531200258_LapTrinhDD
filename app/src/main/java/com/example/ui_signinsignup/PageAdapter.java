package com.example.ui_signinsignup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PageAdapter extends RecyclerView.Adapter<PageAdapter.ViewHoder>{
    ArrayList<Page> dataPages;
    Context context;

    public PageAdapter(ArrayList<Page> dataPages, Context context) {
        this.dataPages = dataPages;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row,parent,false);
        return new ViewHoder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        holder.txtName.setText(dataPages.get(position).getTxt_Name());
        holder.txtDescription.setText(dataPages.get(position).getTxt_Description());
        holder.imgHinh.setImageResource(dataPages.get(position).getSrcImg());
    }

    @Override
    public int getItemCount() {
        if (dataPages != null) {
            return  dataPages.size();
        }
        return 0;
    }


    public class ViewHoder extends RecyclerView.ViewHolder{
        TextView txtName;
        TextView txtDescription;
        ImageView imgHinh;
        public ViewHoder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txt_Name);
            txtDescription = (TextView) itemView.findViewById(R.id.txt_Description);
            imgHinh = (ImageView) itemView.findViewById(R.id.img_hinh);
        }
    }
}