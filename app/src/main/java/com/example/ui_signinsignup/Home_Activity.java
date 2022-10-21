package com.example.ui_signinsignup;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ui_signinsignup.category.Category;
import com.example.ui_signinsignup.category.CategoryAdapter;
import com.example.ui_signinsignup.page.Page;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
//    private TextView btnProfile;
//    private TextView btnList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
//        btnProfile = (TextView) findViewById(R.id.btn_profile);
//        btnProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openProfile();
//            }
//        });
//
//        btnList = (TextView) findViewById(R.id.btn_listGroup);
//        btnList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openList();
//            }
//        });

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.menu_home);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        return true;
                    case R.id.menu_page:
                        startActivity(new Intent(getApplicationContext(), Page_Activity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.menu_profile:
                        startActivity(new Intent(getApplicationContext(), Profile_Activity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                }
                return false;
            }
        });

    }

    Boolean doubleTap = false;
    @Override
    public void onBackPressed() {
        if (doubleTap) {
            finish();
        } else {
            Toast.makeText(Home_Activity.this, "Press Back again to exit the application!", Toast.LENGTH_SHORT).show();
            doubleTap = true;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleTap = false;
                }
            }, 1800);
        }
    }
    public void openProfile(){
        Intent intent = new Intent(this, Profile_Activity.class);
        startActivity(intent);
        finish();
    }
    public void openList(){
        Intent intent = new Intent(this, Page_Activity.class);
        startActivity(intent);
    }
    public void initView() {
        rcvCategory = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
    }

    private ArrayList<Category> getListCategory(){
        ArrayList<Category> listCategory = new ArrayList<>();

        ArrayList<Page> arrayList = new ArrayList<>();
        //imgsrc,Name,Description,(About)
        arrayList.add(new Page(R.drawable.img_bantruyenthong,"Ban Truyền Thông Đoàn trường UTE - Media", "Câu lạc bộ giao lưu", "Ban này sẽ đảm nhiệm vai trò quảng bá hoạt động của Ban, các chương trình do Trường Đại Học Sư phạm Kỹ thuật Đà Nẵng tổ chức.",false));

        arrayList.add(new Page(R.drawable.img_dhspkt,"Trường Đại học Sư phạm Kỹ thuật - Đại Học Đà Nẵng", "Trang web giáo dục","Trang thông tin tuyển sinh - Trường Đại học Sư phạm Kỹ thuật - Đại học Đà Nẵng.",false));
        arrayList.add(new Page(R.drawable.img_tuoitredhdn,"Tuổi trẻ Đại học Đà Nẵng", "Tổ chức cộng đồng", "Đoàn Thanh niên Cộng sản Hồ Chí Minh được thành lập theo quyết định số 24/QÐ-BTV.",false));
        arrayList.add(new Page(R.drawable.img_daiphatthanh, "Đài Phát Thanh","Công ty truyền thông, tin tức", "Từ đây phát ra những tín hiệu thông tin vui vẻ, tích cực và thú vị. Liên hệ với chúng tôi qua: contact.cotdien@gmail.com",false));
        arrayList.add(new Page(R.drawable.img_dienban,"Điện Bàn", "Trang web văn hoá & xã hội","Chào mừng đến với trang fanpage Điện Bàn. Liên Hê quảng cáo vui lòng inbox Fanpage.",false));
        arrayList.add(new Page(R.drawable.img_garena, "Garena Liên Quân Mobile", "Trò chơi điện tử", "Fanpage chính thức dành cho người chơi Liên Quân Mobile. Tất cả các sự kiện và thông tin quan trọng sẽ được thông báo chính thức tại đây.",false));
        arrayList.add(new Page(R.drawable.img_yody, "YODY","Cửa hàng quần áo", "Yody - Trải nghiệm tuyệt vời",false));

        listCategory.add(new Category("Page Tổ Chức", arrayList, false));

        ArrayList<Page> arrayList1 = new ArrayList<>();
        arrayList1.add(new Page(R.drawable.img_cris,"Cris Devil Gamer", "Nghệ sỹ", "Hello Các bạn, Chào mừng các bạn đã trở lại với channel của mình, mình là Cris Devil Gamer.",false));
        arrayList1.add(new Page(R.drawable.img_mixigaming,"Mixi Gaming", "Người tạo video chơi game","Hí Anh em, Mình là Độ.",false));
        arrayList1.add(new Page(R.drawable.img_denvau,"Đen Vâu FC", "Trang dành cho fan của Đen", "Đen Vâu FC là cộng đồng Đồng âm lớn nhất của Đen Vâu.",false));
        arrayList1.add(new Page(R.drawable.img_tranthanh,"Trấn Thành", "Nghệ sĩ", "Kênh Youtube chính thức : https://youtube.com/TRANTHANHTOWN.",false));

        listCategory.add(new Category("Page Cá Nhân", arrayList1, false));
        return listCategory;
    }

}