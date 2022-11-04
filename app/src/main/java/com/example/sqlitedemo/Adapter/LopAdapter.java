package com.example.sqlitedemo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlitedemo.DsSvActivity;
import com.example.sqlitedemo.Model.Lop;
import com.example.sqlitedemo.R;

import java.util.ArrayList;

public class LopAdapter extends RecyclerView.Adapter<LopAdapter.ViewHolder>{
    ArrayList<Lop> listlop_258;
    Context context;

    public LopAdapter(ArrayList<Lop> listlop_258, Context context) {
        this.listlop_258 = listlop_258;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_lop, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Lop lop_258 = listlop_258.get(position);
        if (lop_258 == null){
            return;
        }
        holder.name_258.setText(lop_258.getTenlop_258());
        holder.siso_258.setText(String.valueOf(lop_258.getSiso_258()));
        holder.main_card_258.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DsSvActivity.class);
                intent.putExtra("Ma", lop_258.getMalop_258());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listlop_258.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name_258, siso_258;
        CardView main_card_258;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name_258 = itemView.findViewById(R.id.tenLop_258);
            siso_258 = itemView.findViewById(R.id.siso_258);
            main_card_258 = (CardView) itemView.findViewById(R.id.main_card);
        }
    }
}

