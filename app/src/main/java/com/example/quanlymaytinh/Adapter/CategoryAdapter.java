package com.example.quanlymaytinh.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlymaytinh.ComputerActivity;
import com.example.quanlymaytinh.Model.Category;
import com.example.quanlymaytinh.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<Category> listCate;
    Context context;

    public CategoryAdapter(ArrayList<Category> listCate, Context context) {
        this.listCate = listCate;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_category, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = listCate.get(position);
        if (category == null){
            return;
        }
        holder.ten.setText(category.getTenCategory());
        holder.soluong.setText(String.valueOf(category.getSoLuong()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ComputerActivity.class);
                intent.putExtra("Ma", category.getMaCategory());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCate.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView ten, soluong;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ten = (TextView) itemView.findViewById(R.id.tenCa);
            soluong = (TextView) itemView.findViewById(R.id.soluong);

            cardView = (CardView) itemView.findViewById(R.id.main_card);
        }
    }
}
