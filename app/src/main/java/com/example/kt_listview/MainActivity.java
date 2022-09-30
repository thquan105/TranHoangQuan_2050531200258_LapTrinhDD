package com.example.kt_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvNhom;
    ArrayList<Nhom> arrNhom;
    nhomAdapter adapter;
    Button btThem;
    EditText edtTenNhom, edtMota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        adapter = new nhomAdapter(this,R.layout.dong_nhom,arrNhom);
        lvNhom.setAdapter(adapter);

        btThem = (Button) findViewById(R.id.buttonThem);
        edtTenNhom = (EditText) findViewById(R.id.textTenNhom);
        edtMota = (EditText)   findViewById(R.id.textMoTa);

        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenNhom = edtTenNhom.getText().toString();
                String mota = edtMota.getText().toString();
                arrNhom.add(new Nhom(tenNhom,mota,R.drawable.botoc));
                adapter.notifyDataSetChanged();
            }
        });

        lvNhom.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrNhom.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    private void AnhXa(){
        lvNhom = (ListView) findViewById(R.id.listviewNhom);
        arrNhom = new ArrayList<>();

        arrNhom.add(new Nhom("Bộ Tộc Mixigaminh","Cộng Động Bộ Tộc",R.drawable.botoc));
        arrNhom.add(new Nhom("Văn Vở","Giao Lưu văn vở",R.drawable.vanvo));
    }
}