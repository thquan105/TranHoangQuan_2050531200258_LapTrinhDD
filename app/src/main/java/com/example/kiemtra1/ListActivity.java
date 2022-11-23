package com.example.kiemtra1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    ArrayList<Thuoc> items = new ArrayList<>();
    DatabaseReference mData;
    ThuocAdaptor adapter;
    ImageView btnLogout;
    Boolean kt=false;
    int j=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.lvThuoc);
        //tên khoa học, tên thường gọi, đặc tính, màu lá, công dụng, duocTinh, chuY, hình ảnh
        items.add(new Thuoc("Xanthium strumarium L.","Thương nhĩ","","Xanh", "Tiêu độc, sát trùng, tán phong thông khiếu, trừ thấp. Chữa phong hàn, đau đầu, chân tay co rút, đau khớp, mũi chảy nước hôi, mày đay, lở ngứa, tràng nhạc, mụn nhọt, mẩn ngứa.", "", "",R.drawable.thuongnhi)) ;
        items.add(new Thuoc("Croton tonkinensis Gagnep", "Khổ sâm Bắc bộ", "", "Xanh Đậm", "Thanh nhiệt, giải độc, sát trùng. Chữa viêm loét dạ dày, tiêu hóa kém, mụn nhọt, lở loét ngoài da, viêm mũi.","","",R.drawable.khosam)) ;
        items.add(new Thuoc("Lonicera japonica Thunb","Dây nhẫn đông","","Xanh","Thanh nhiệt giải độc, tán phong nhiệt. Chữa mụn nhọt, mề đay, lở ngứa, nhiệt độc ban sởi, dị ứng, lỵ, cảm mạo phong nhiệt, ho do phế nhiệt, viêm mũi dị ứng.","","",R.drawable.kimngan));

        adapter = new ThuocAdaptor(ListActivity.this,items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListActivity.this,DetailActivity.class);
                intent.putExtra("Ten",items.get(i).getTenKhoaHoc()+" ("+items.get(i).getTenThuongGoi()+")");
                intent.putExtra("MoTa",items.get(i).getDacTinh());
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                kt=true;
                Xacnhanxoa(i);
                return false;
            }
        });

        btnLogout = (ImageView) findViewById(R.id.btn_Logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }




    public void Xacnhanxoa(final int pos){
        AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(ListActivity.this);
        alertDiaLog.setTitle("Thông báo");
        alertDiaLog.setIcon(R.mipmap.ic_launcher);
        alertDiaLog.setMessage("Bạn có muốn xóa");
        alertDiaLog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                items.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
        alertDiaLog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDiaLog.show();
    }
}