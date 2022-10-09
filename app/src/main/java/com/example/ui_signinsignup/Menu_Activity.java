package com.example.ui_signinsignup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Menu_Activity extends AppCompatActivity {
    private TextView btnProfile;
    private TextView btnList;
    private Button btnOut;
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
                openProfile();
            }
        });

        btnOut = (Button) findViewById(R.id.btnLogout);
        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit();
            }
        });
    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        exit();
    }
    public void openProfile(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openList(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openLogout(){
        Intent intent = new Intent(this, Login_Activity.class);
        startActivity(intent);
        finish();
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
                Toast.makeText(Menu_Activity.this, "Successful Logout", Toast.LENGTH_SHORT).show();
                openLogout();
            }
        });

        alertDialogBuilder.setPositiveButton("Cancel", null);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}