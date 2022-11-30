package com.example.tacgiatacpham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class TacPhamActivity extends AppCompatActivity {
    private String matg;
    private RecyclerView rcvTacPham;
    private TacPhamAdapter tacPhamAdapter;
    ArrayList<TacPham> tacPhamArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tac_pham);
        initView();


    }
    public void initView() {
        rcvTacPham = findViewById(R.id.rcv_tacpham);
        rcvTacPham.setHasFixedSize(true);
        tacPhamArrayList = new ArrayList<TacPham>();


        matg = getIntent().getExtras().getString("ma");

        switch (matg){
            case "tg1":
                tacPhamArrayList.add(new TacPham("Trời mỗi ngày lại sáng","1958","Tập thơ","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Hai bàn tay em","1967","tập thơ thiếu nhi","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Ngôi nhà giữa nắng","1978","Tập thơ","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Hạt lại gieo","1958","Tập thơ","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Chim làm ra gió","1958","Tập thơ","mô tả",R.drawable.thohuycan));
                break;
            case "tg2":
                tacPhamArrayList.add(new TacPham("Trời mỗi ngày lại sáng","1958","Tập thơ","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Hai bàn tay em","1967","tập thơ thiếu nhi","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Ngôi nhà giữa nắng","1978","Tập thơ","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Hạt lại gieo","1958","Tập thơ","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Chim làm ra gió","1958","Tập thơ","mô tả",R.drawable.thohuycan));
                break;
            case "tg3":
                tacPhamArrayList.add(new TacPham("Trời mỗi ngày lại sáng","1958","Tập thơ","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Hai bàn tay em","1967","tập thơ thiếu nhi","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Ngôi nhà giữa nắng","1978","Tập thơ","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Hạt lại gieo","1958","Tập thơ","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Chim làm ra gió","1958","Tập thơ","mô tả",R.drawable.thohuycan));
               break;
            case "tg4":
                tacPhamArrayList.add(new TacPham("Trời mỗi ngày lại sáng","1958","Tập thơ","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Hai bàn tay em","1967","tập thơ thiếu nhi","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Ngôi nhà giữa nắng","1978","Tập thơ","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Hạt lại gieo","1958","Tập thơ","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Chim làm ra gió","1958","Tập thơ","mô tả",R.drawable.thohuycan));
                break;
            case "tg5":
                tacPhamArrayList.add(new TacPham("Trời mỗi ngày lại sáng","1958","Tập thơ","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Hai bàn tay em","1967","tập thơ thiếu nhi","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Ngôi nhà giữa nắng","1978","Tập thơ","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Hạt lại gieo","1958","Tập thơ","mô tả",R.drawable.thohuycan));
                tacPhamArrayList.add(new TacPham("Chim làm ra gió","1958","Tập thơ","mô tả",R.drawable.thohuycan));
                break;
        }

        tacPhamAdapter = new TacPhamAdapter(this, tacPhamArrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvTacPham.setLayoutManager(linearLayoutManager);

        rcvTacPham.setAdapter(tacPhamAdapter);

    }
}