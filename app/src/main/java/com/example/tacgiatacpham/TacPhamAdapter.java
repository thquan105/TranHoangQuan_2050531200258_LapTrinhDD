package com.example.tacgiatacpham;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TacPhamAdapter extends RecyclerView.Adapter<TacPhamAdapter.myViewHolder> {
    Context context;
    ArrayList<TacPham> dsTacPham;

    public TacPhamAdapter(Context context, ArrayList<TacPham> dsTacPham) {
        this.context = context;
        this.dsTacPham = dsTacPham;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_tacpham ,parent,false);
        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        TacPham tacPham = dsTacPham.get(position);

        if (tacPham == null){
            return;
        }
        holder.ten.setText(tacPham.getTen());
        holder.nam.setText(tacPham.getNam());
        holder.img.setImageResource(tacPham.getHinhanh());
        holder.theloai.setText(tacPham.getTheloai());

    }

    @Override
    public int getItemCount() {
        if (dsTacPham != null) {
            return dsTacPham.size();
        }
        return 0;
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView ten, nam, theloai;
        CircleImageView img;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView) itemView.findViewById(R.id.img_avatar);
            ten = itemView.findViewById(R.id.tv_ten);
            nam = itemView.findViewById(R.id.tv_nam);
            theloai = itemView.findViewById(R.id.tv_theloai);
        }
    }
}

