package com.example.ui_signinsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {
    private Button btSignIn;
    private TextView txtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        EditText username= (EditText) findViewById(R.id.txtusername);
        EditText password= (EditText) findViewById(R.id.txtpassword);
//      Event Log In
        btSignIn = (Button) findViewById(R.id.btnLogin);
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("quan") && password.getText().toString().equals("abc"))
                {
                    Toast.makeText(Login_Activity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                    openMenu();
                    finish();
                }
                else
                {
                    Toast.makeText(Login_Activity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    username.requestFocus();
                }
            }
        });
//      Event Sign Up
        txtview = (TextView) findViewById(R.id.txtSignUp);
        txtview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUp();
            }
        });
    }
    Boolean doubleTap = false;
    @Override
    public void onBackPressed() {
        if (doubleTap) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(Login_Activity.this, "Press Back again to exit the application!", Toast.LENGTH_SHORT).show();
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

    public void openMenu(){
        Intent intent = new Intent(this, Menu_Activity.class);
        startActivity(intent);
    }
    public void openSignUp(){
        Intent intent = new Intent(this, Signup_Activity.class);
        startActivity(intent);
    }
}