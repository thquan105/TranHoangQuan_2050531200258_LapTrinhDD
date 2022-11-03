package com.example.quanlymaytinh.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlymaytinh.Model.Computer;
import com.example.quanlymaytinh.R;

import java.util.ArrayList;


public class ComputerAdapter extends RecyclerView.Adapter<ComputerAdapter.ViewHolder> {
    ArrayList<Computer> computerList;
    Context context;

    public ComputerAdapter(ArrayList<Computer> computerList, Context context) {
        this.computerList = computerList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_computer, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Computer com = computerList.get(position);
        if ( com == null)
        {
            return;
        }
        holder.txtTen.setText(com.getTenComputer());
        holder.txtmoTa.setText(com.getMoTa());
    }

    @Override
    public int getItemCount() {
        return computerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    TextView txtTen, txtmoTa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTen = itemView.findViewById(R.id.tenCom);
            txtmoTa = itemView.findViewById(R.id.moTa);
        }
    }
}
