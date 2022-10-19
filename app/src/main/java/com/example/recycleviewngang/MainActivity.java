package com.example.recycleviewngang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvCategory = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
    }

    private ArrayList<Category> getListCategory(){
        ArrayList<Category> listCategory = new ArrayList<>();

        //Category 1
        ArrayList<Phone> list_iPhone = new ArrayList<>();
        list_iPhone.add(new Phone("iPhone 14 128GB", "23.990.000", R.drawable.iphone14_128gb));
        list_iPhone.add(new Phone("iPhone 14 Pro Max", "33.990.000", R.drawable.iphone_14_pro_max_256gb_purple));
        list_iPhone.add(new Phone("iPhone 14 128GB", "23.990.000", R.drawable.iphone14_128gb));
        list_iPhone.add(new Phone("iPhone 14 Pro Max", "33.990.000", R.drawable.iphone_14_pro_max_256gb_purple));
        list_iPhone.add(new Phone("iPhone 14 128GB", "23.990.000", R.drawable.iphone14_128gb));
        list_iPhone.add(new Phone("iPhone 14 Pro Max", "33.990.000", R.drawable.iphone_14_pro_max_256gb_purple));
        list_iPhone.add(new Phone("iPhone 14 128GB", "23.990.000", R.drawable.iphone14_128gb));
        list_iPhone.add(new Phone("iPhone 14 Pro Max", "33.990.000", R.drawable.iphone_14_pro_max_256gb_purple));

        listCategory.add(new Category("IPHONE", list_iPhone));

        //Category 2
        ArrayList<Phone> list_ss = new ArrayList<>();
        list_ss.add(new Phone("Galaxy Z Flip", "24.990.000", R.drawable.samsung_galaxy_z_flip));
        list_ss.add(new Phone("Galaxy A53 5G", "9.990.000", R.drawable.sm_a536_galaxy_a53_5g));
        list_ss.add(new Phone("Galaxy S22 Ultra", "30.990.000", R.drawable.sm_s908_galaxys22ultra_front_burgundy));
        list_ss.add(new Phone("Galaxy Z Flip", "24.990.000", R.drawable.samsung_galaxy_z_flip));
        list_ss.add(new Phone("Galaxy A53 5G", "9.990.000", R.drawable.sm_a536_galaxy_a53_5g));
        list_ss.add(new Phone("Galaxy S22 Ultra", "30.990.000", R.drawable.sm_s908_galaxys22ultra_front_burgundy));
        list_ss.add(new Phone("Galaxy Z Flip", "24.990.000", R.drawable.samsung_galaxy_z_flip));
        list_ss.add(new Phone("Galaxy A53 5G", "9.990.000", R.drawable.sm_a536_galaxy_a53_5g));
        list_ss.add(new Phone("Galaxy S22 Ultra", "30.990.000", R.drawable.sm_s908_galaxys22ultra_front_burgundy));

        listCategory.add(new Category("SAMSUNG", list_ss));

        //Category 3
        ArrayList<Phone> list_mi = new ArrayList<>();
        list_mi.add(new Phone("Redmi 11 Pro", "9.990.000", R.drawable.xiaomi_redmi_11_pro_plus_blue));
        list_mi.add(new Phone("Xiaomi 12T Pro", "16.990.000", R.drawable.xiaomi_12t_pro));
        list_mi.add(new Phone("Redmi 11 Pro", "9.990.000", R.drawable.xiaomi_redmi_11_pro_plus_blue));
        list_mi.add(new Phone("Xiaomi 12T Pro", "16.990.000", R.drawable.xiaomi_12t_pro));
        list_mi.add(new Phone("Redmi 11 Pro", "9.990.000", R.drawable.xiaomi_redmi_11_pro_plus_blue));
        list_mi.add(new Phone("Xiaomi 12T Pro", "16.990.000", R.drawable.xiaomi_12t_pro));

        listCategory.add(new Category("XIAOMI", list_mi));

        return listCategory;
    }
}