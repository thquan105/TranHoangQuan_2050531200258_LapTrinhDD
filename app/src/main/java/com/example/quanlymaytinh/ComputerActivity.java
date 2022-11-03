package com.example.quanlymaytinh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlymaytinh.Adapter.CategoryAdapter;
import com.example.quanlymaytinh.Adapter.ComputerAdapter;
import com.example.quanlymaytinh.Model.Category;
import com.example.quanlymaytinh.Model.Computer;

import java.util.ArrayList;

public class ComputerActivity extends AppCompatActivity {
    public static DBHelper dbHelper;
    public static ArrayList<Computer> arrayList = new ArrayList<>();
    public static RecyclerView recyclerView;
    public static String maCa;
    public static ComputerAdapter computerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

        recyclerView = (RecyclerView) findViewById(R.id.rcv_Computer);

        maCa = getIntent().getExtras().getString("Ma");

        dbHelper = new DBHelper(this, "qlMayTinh", null, 1);
        //cuộn mượt hơn
        recyclerView.setHasFixedSize(true);
        getDataComputer();

        Button button = (Button) findViewById(R.id.btn_themComputer);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(ComputerActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_computer);
                dialog.show();
                EditText tv1 = (EditText) dialog.findViewById(R.id.isIDCo);
                EditText tv2 = (EditText) dialog.findViewById(R.id.isNameCo);
                EditText tv3 = (EditText) dialog.findViewById(R.id.isMota);
                EditText tv4 = (EditText) dialog.findViewById(R.id.isIDCate);

                tv4.setText(maCa.trim());
                Button btok = (Button) dialog.findViewById(R.id.btn_okCo);
                Button btcancel = (Button) dialog.findViewById(R.id.btn_cancelCo);
                btok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dbHelper.QueryData("INSERT INTO tblComputer (maComputer, tenComputer, moTa, maCategory) VALUES('"+tv1.getText().toString().trim()+"', '"+tv2.getText().toString().trim()+"', '"+tv3.getText().toString().trim()+"', '"+tv4.getText().toString()+"')");
                        getDataComputer();
                        dialog.dismiss();
                    }
                });
                btcancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
            }
        });
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataComputer();
            }
        });
    }

        public void getDataComputer() {
            ComputerActivity.arrayList = new ArrayList<Computer>();
            //Lấy dữ liệu
            Cursor dataCom = dbHelper.GetData("SELECT * FROM tblComputer WHERE maCategory = '"+ maCa.trim()+"'");

            dataCom.moveToFirst();
            while (!dataCom.isAfterLast()){
                String ma = dataCom.getString(0);
                String ten = dataCom.getString(1);
                String mota = dataCom.getString(2);
                arrayList.add(new Computer(ma, ten, mota, maCa.trim()));
                dataCom.moveToNext();
            }
            dataCom.close();
            //Quy định kiểu hiển thị
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
            recyclerView.setLayoutManager(layoutManager);
            computerAdapter = new ComputerAdapter(arrayList, getApplicationContext());
            recyclerView.setAdapter(computerAdapter);
        }
    }