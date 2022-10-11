package com.example.ui_signinsignup;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Menu_Activity extends AppCompatActivity {
    private TextView btnProfile;
    private TextView btnList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnProfile = (TextView) findViewById(R.id.btn_profile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProfile();
            }
        });

        btnList = (TextView) findViewById(R.id.btn_listGroup);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openList();
            }
        });

    }

    Boolean doubleTap = false;
    @Override
    public void onBackPressed() {
        if (doubleTap) {
            finish();
        } else {
            Toast.makeText(Menu_Activity.this, "Press Back again to exit the application!", Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void openList(){
        Intent intent = new Intent(this, Page_Activity.class);
        startActivity(intent);
    }

}