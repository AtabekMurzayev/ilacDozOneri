package com.nexis.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ilaclarActivity extends AppCompatActivity {

    private Button btn_parol120;
    private Button btn_parolplus;
    private Button btn_calpol120;
    private Button btn_calpol6plus;
    private Button btn_dolven;
    private Button btn_ibuford;
    private Button other_btn;
    private Button btn_next;
    private Button btn_back;
    private static String ilac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilaclar);
        btn_back=(Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ilaclarActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_next=(Button)findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(ilaclarActivity.this,kiloActivity.class);
                startActivity(intent);
            }
        });

        btn_parol120=findViewById(R.id.btn_parol120);
        btn_parol120.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ilac = "1";

            }
        });
        btn_parol120.setClickable(true);
        btn_parolplus=(Button) findViewById(R.id.btn_parolplus);
        btn_parolplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ilac = "2";
            }
        });
        btn_parolplus.setClickable(true);
        btn_calpol120=(Button) findViewById(R.id.btn_calpol120);
        btn_calpol120.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ilac = "3";
            }
        });
        btn_calpol6plus=(Button) findViewById(R.id.btn_calpol6plus);
        btn_calpol6plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ilac = "4";
            }
        });
        btn_dolven=(Button) findViewById(R.id.btn_dolven);
        btn_dolven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ilac = "5";
            }
        });
        btn_ibuford=(Button) findViewById(R.id.btn_ibuford);
        btn_ibuford.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ilac = "6";
            }
        });
        other_btn=(Button) findViewById(R.id.other_btn);
        other_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        btn_parolplus.setFocusable(true);
        btn_calpol120.setClickable(true);
        btn_calpol6plus.setClickable(true);
        btn_dolven.setClickable(true);
        btn_ibuford.setClickable(true);

    }
}