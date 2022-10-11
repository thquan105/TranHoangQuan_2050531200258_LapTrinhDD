package com.example.ui_signinsignup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView btBack;
    private ImageView btnOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //      Event Back
        btBack = (ImageView) findViewById(R.id.btnBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });

        btnOut = (ImageView) findViewById(R.id.btnLogout);
        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit();
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
                Toast.makeText(MainActivity.this, "Successful Logout", Toast.LENGTH_SHORT).show();
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
    public void openMenu(){
        Intent intent = new Intent(this, Menu_Activity.class);
        startActivity(intent);
        finish();
    }
}