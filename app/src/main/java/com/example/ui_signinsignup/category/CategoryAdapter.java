package com.example.ui_signinsignup.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ui_signinsignup.R;
import com.example.ui_signinsignup.page.Page;
import com.example.ui_signinsignup.page.PageAdapter;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    private static int TYPE_PAGE_V;

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
    public int getItemViewType(int position) {
            Category category = listCategory.get(position);
            if (category.isH()){
                TYPE_PAGE_V = 1;
            } else {
                TYPE_PAGE_V = 0;
            }
        return super.getItemViewType(position);
    }

    //    V = Dọc, H = Ngang

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = listCategory.get(position);
        if (category == null){
            return;
        }
        holder.txtNameCategory.setText(category.getNameCategory());
        if (TYPE_PAGE_V == 1) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
            holder.rcvPage.setLayoutManager(linearLayoutManager);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
            holder.rcvPage.setLayoutManager(linearLayoutManager);
        }


        PageAdapter pageAdapter = new PageAdapter();
        pageAdapter.setData(category.getPages());
        holder.rcvPage.setAdapter(pageAdapter);
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
        private RecyclerView rcvPage;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNameCategory = itemView.findViewById(R.id.txt_name_category);
            rcvPage = itemView.findViewById(R.id.rcv_page);
        }
    }
}