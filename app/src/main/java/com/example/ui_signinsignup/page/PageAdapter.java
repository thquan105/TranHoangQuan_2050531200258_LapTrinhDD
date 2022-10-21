package com.example.ui_signinsignup.page;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ui_signinsignup.Detail_Activity;
import com.example.ui_signinsignup.R;

import java.util.ArrayList;

public class PageAdapter extends RecyclerView.Adapter<PageAdapter.ViewHoder>{
    private static int TYPE_PAGE_V = 1;
    private static int TYPE_PAGE_H = 2;
    ArrayList<Page> dataPages;

    public void setData(ArrayList<Page> dataPages) {
        this.dataPages = dataPages;
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        Page page = dataPages.get(position);
        if (page.isH()){
            return TYPE_PAGE_V;
        } else {
            return TYPE_PAGE_H;
        }
    }
//    V = Dọc, H = Ngang


    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (TYPE_PAGE_V == viewType) {
            View itemView = layoutInflater.inflate(R.layout.item_row, parent, false);
            return new ViewHoder(itemView);
        } else if (TYPE_PAGE_H == viewType){
            View itemView = layoutInflater.inflate(R.layout.item_page, parent, false);
            return new ViewHoder(itemView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        Page page = dataPages.get(position);
        if (page == null){
            return;
        }
        holder.txtName.setText(page.getTxt_Name());
        holder.txtDescription.setText(page.getTxt_Description());
        holder.imgHinh.setImageResource(page.getSrcImg());

        holder.main_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Detail_Activity.class);
                intent.putExtra("Name", page.getTxt_Name());
                intent.putExtra("Des", page.getTxt_Description());
                intent.putExtra("image", page.getSrcImg());
                intent.putExtra("about", page.getTxt_About());
                view.getContext().startActivity(intent);
            }
        });
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
        CardView main_card;

        public ViewHoder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txt_Name);
            txtDescription = (TextView) itemView.findViewById(R.id.txt_Description);
            imgHinh = (ImageView) itemView.findViewById(R.id.img_hinh);
            main_card = (CardView) itemView.findViewById(R.id.main_card);
        }
    }
}