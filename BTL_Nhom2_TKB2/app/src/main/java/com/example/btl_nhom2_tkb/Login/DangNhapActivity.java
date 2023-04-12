package com.example.btl_nhom2_tkb.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_nhom2_tkb.MainActivity;
import com.example.btl_nhom2_tkb.R;


public class DangNhapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap);


        TextView username =(TextView) findViewById(R.id.taikhoan);
        TextView password =(TextView) findViewById(R.id.matkhau);
        TextView forgetpass =(TextView) findViewById(R.id.quenpass);
        TextView register =(TextView) findViewById(R.id.dangky);

        Button loginbtn = (Button) findViewById(R.id.dangnhap);
        DBHelper DB = new DBHelper(this);
        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                if(checkuserpass==true){
                    //correct
                    Toast.makeText(DangNhapActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DangNhapActivity.this, MainActivity.class);
                    startActivity(intent);
                }else
                    //incorrect
                    Toast.makeText(DangNhapActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DangNhapActivity.this, DangKyActivity.class);
                startActivity(intent);
            }
        });
        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DangNhapActivity.this, QuenPass.class);
                startActivity(intent);
            }
        });
    }
}
