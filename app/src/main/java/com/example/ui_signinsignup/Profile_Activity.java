package com.example.ui_signinsignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile_Activity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
//    private ImageView btBack;
    private ImageView btnOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//        //      Event Back
//        btBack = (ImageView) findViewById(R.id.btnBack);
//        btBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openMenu();
//            }
//        });

        btnOut = (ImageView) findViewById(R.id.btnLogout);
        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit();
            }
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.menu_profile);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        startActivity(new Intent(getApplicationContext(), Home_Activity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                    case R.id.menu_page:
                        startActivity(new Intent(getApplicationContext(), Page_Activity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                    case R.id.menu_profile:
                        return true;
                }
                return false;
            }
        });
    }
    public void exit(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // Setting Alert Dialog Title
        alertDialogBuilder.setTitle("Confirm..!!!");
        // Icon Of Alert Dialog
        alertDialogBuilder.setIcon(R.drawable.ic_confirm);
        // Setting Alert Dialog Message
        alertDialogBuilder.setMessage("Are you sure, You want to Logout ?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(Profile_Activity.this, "Successful Logout", Toast.LENGTH_SHORT).show();
                openLogout();
            }
        });

        alertDialogBuilder.setPositiveButton("Cancel", null);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public void openLogout(){
        Intent intent = new Intent(this, Login_Activity.class);
        startActivity(intent);
        finish();
    }
    Boolean doubleTap = false;
    @Override
    public void onBackPressed() {
        if (doubleTap) {
            finish();
        } else {
            Toast.makeText(Profile_Activity.this, "Press Back again to exit the application!", Toast.LENGTH_SHORT).show();
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
//    public void openMenu(){
//        Intent intent = new Intent(this, Home_Activity.class);
//        startActivity(intent);
//        finish();
//    }
}