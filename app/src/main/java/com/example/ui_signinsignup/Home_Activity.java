package com.example.ui_signinsignup;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home_Activity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private TextView btnProfile;
    private TextView btnList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.menu_profile:
                        startActivity(new Intent(getApplicationContext(), Profile_Activity.class));
                        overridePendingTransition(0, 0);
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

}