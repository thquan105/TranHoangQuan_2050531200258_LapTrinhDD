package com.example.kiemtra1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtUser, txtPass;
    CheckBox cbRemem;
    Button btnLogin;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser = (EditText) findViewById(R.id.username);
        txtPass = (EditText) findViewById(R.id.passwork);
        cbRemem = (CheckBox) findViewById(R.id.cbRemember);
        btnLogin = (Button) findViewById(R.id.btlogin);

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);

        if (sharedPreferences.getBoolean("checked",false)==true){
            txtUser.setText(sharedPreferences.getString("taikhoan",""));
            txtPass.setText(sharedPreferences.getString("matkhau",""));
            cbRemem.setChecked(true);
        }else cbRemem.setChecked(false);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtUser.getText().toString().trim();
                String password = txtPass.getText().toString().trim();

                if (username.equals("tranhoangquan") && password.equals("2050531200258")) {
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(MainActivity.this, ListActivity.class);
                    startActivity(intent);
                    checkRemember(username, password);
                    finish();
                }
                else Toast.makeText(MainActivity.this,"Sai tài khoản hoặc mật khẩu",Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void checkRemember(String username, String password) {
        if (cbRemem.isChecked()){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("taikhoan", username);
            editor.putString("matkhau", password);
            editor.putBoolean("checked",true);
            editor.commit();
        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove("taikhoan");
            editor.remove("matkhau");
            editor.remove("checked");
            editor.commit();
        }

    }
}