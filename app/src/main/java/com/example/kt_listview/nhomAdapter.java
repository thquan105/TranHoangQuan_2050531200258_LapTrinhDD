package com.example.kt_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class nhomAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Nhom> nhomList;

    public nhomAdapter(Context context, int layout, List<Nhom> nhomList) {
        this.context = context;
        this.layout = layout;
        this.nhomList = nhomList;
    }

    @Override
    public int getCount() {
        return nhomList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        //ánh xạ
        TextView textTen = (TextView) view.findViewById(R.id.txtTen);
        TextView textMota = (TextView) view.findViewById(R.id.txtMota);
        ImageView imgAnh = (ImageView) view.findViewById(R.id.imageNhom);

        // gán
        Nhom nhom = nhomList.get(i);

        textTen.setText(nhom.getTen());
        textMota.setText(nhom.getMota());
        imgAnh.setImageResource(nhom.getAnh());



        return view;
    }

}
