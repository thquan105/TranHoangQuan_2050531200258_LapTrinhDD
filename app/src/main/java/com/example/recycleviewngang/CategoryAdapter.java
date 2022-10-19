package com.example.recycleviewngang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    private Context context;
    private ArrayList<Category> listCategory;

    public CategoryAdapter(Context context){
        this.context = context;
    }
    public void setData(ArrayList<Category> list) {
        this.listCategory = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_category,parent,false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = listCategory.get(position);
        if (category == null){
            return;
        }
        holder.txtNameCategory.setText(category.getNameCategory());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        holder.rcvPhone.setLayoutManager(linearLayoutManager);
        PhoneAdapter phoneAdapter = new PhoneAdapter();
        phoneAdapter.setData(category.getPhones());
        holder.rcvPhone.setAdapter(phoneAdapter);
    }

    @Override
    public int getItemCount() {
        if (listCategory != null) {
            return listCategory.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNameCategory;
        private RecyclerView rcvPhone;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNameCategory = itemView.findViewById(R.id.txt_name_category);
            rcvPhone = itemView.findViewById(R.id.rcv_phone);
        }
    }
}
