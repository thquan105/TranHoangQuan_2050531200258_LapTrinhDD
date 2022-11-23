package com.example.kiemtra1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ThuocAdaptor extends BaseAdapter {
    Activity activity;
    List<Thuoc> thuocs;

    public ThuocAdaptor(Activity activity, List<Thuoc> cayXanhs) {
        this.activity = activity;
        this.thuocs = cayXanhs;
    }
    @Override
    public int getCount() {
        return thuocs.size();
    }

    @Override
    public Object getItem(int i) {
        return thuocs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.item_row, null);

        TextView tvName = (TextView) view.findViewById(R.id.txt_ten);
        TextView tvNameThuong = (TextView) view.findViewById(R.id.txt_tenThuong);
        TextView tvMauLa = (TextView) view.findViewById(R.id.txt_mauLa);
        TextView tvDacTinh = (TextView) view.findViewById(R.id.txt_dacTinh);

        ImageView imageView = (ImageView) view.findViewById(R.id.hinhanh);

        tvName.setText(thuocs.get(i).getTenKhoaHoc());
        tvNameThuong.setText("("+thuocs.get(i).getTenThuongGoi()+")");
        tvMauLa.setText(String.valueOf("Màu lá: "+thuocs.get(i).getMauLa()));
        tvDacTinh.setText(String.valueOf("Đặc tính: "+thuocs.get(i).getDacTinh()));
        imageView.setImageResource(thuocs.get(i).getHinhAnh());
        return view;
    }
}
