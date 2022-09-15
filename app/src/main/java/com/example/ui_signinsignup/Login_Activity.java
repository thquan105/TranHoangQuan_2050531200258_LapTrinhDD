package com.example.ui_signinsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
                    openProfile();
                }
                else
                {
                    Toast.makeText(Login_Activity.this,"Login Failed",Toast.LENGTH_SHORT).show();
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
    public void openProfile(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openSignUp(){
        Intent intent = new Intent(this, Signup_Activity.class);
        startActivity(intent);
    }
}