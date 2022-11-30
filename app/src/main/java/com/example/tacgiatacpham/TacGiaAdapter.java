package com.example.tacgiatacpham;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TacGiaAdapter extends RecyclerView.Adapter<TacGiaAdapter.myViewHolder> {
    Context context;
    ArrayList<TacGia> dsTacgia;

    public TacGiaAdapter(Context context, ArrayList<TacGia> dsTacgia) {
        this.context = context;
        this.dsTacgia = dsTacgia;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_tacgia,parent,false);
        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        TacGia tacGia = dsTacgia.get(position);

        if (tacGia == null){
            return;
        }
        holder.ten.setText(tacGia.getTenTacGia());
        holder.mota.setText(tacGia.getMoTa());
        holder.img.setImageResource(tacGia.getHinhanh());
        holder.ratingBar.setRating((float) tacGia.getRate());

        holder.Ctacgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TacPhamActivity.class);
                intent.putExtra("ma", tacGia.getMaTacgia());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (dsTacgia != null) {
            return dsTacgia.size();
        }
        return 0;
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView ten, mota;
        CircleImageView img;
        RatingBar ratingBar;
        CardView Ctacgia;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView) itemView.findViewById(R.id.img_avatar);
            ten = itemView.findViewById(R.id.tv_tenTacGia);
            mota = itemView.findViewById(R.id.tv_mota);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            Ctacgia = itemView.findViewById(R.id.card_tacgia);
        }
    }
}
