package com.example.btl_nhom2_tkb.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_nhom2_tkb.R;

public class QuenPass extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quenmatkhau);


        TextView username =(TextView) findViewById(R.id.taikhoancuaban);
        TextView password =(TextView) findViewById(R.id.edit_pass_moi);
        TextView repassword =(TextView) findViewById(R.id.edit_pass_moi2);

        Button Confirmbtn = (Button) findViewById(R.id.xac_nhan_doi_pass);
        Button CancelBtn = (Button) findViewById(R.id.huy_doi_pass);
        DBHelper DB = new DBHelper(this);
        //admin and admin

        Confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                Boolean checkuser = DB.checkusername(user);
                if(pass.equals(repass)){
                    //correct
                    if(DB.updateContact(user,pass)) {
                        Toast.makeText(QuenPass.this, "FORGET PASS SUCCESSFUL", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(QuenPass.this, DangNhapActivity.class);
                        startActivity(intent);
                    }
                }else
                    //incorrect
                    Toast.makeText(QuenPass.this,"FORGET PASS FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });

        CancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QuenPass.this, DangNhapActivity.class);
                startActivity(intent);
            }
        });

    }
}
