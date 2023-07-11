package com.nexis.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;
import java.text.DecimalFormat;




    public class kiloActivity extends AppCompatActivity {

        private Button btn_Kilo_hesapla;
        private EditText edt_Kilo;
        private UserData userData;
        private UserData1 userData1;
        private Button btn_back;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_kilo);
            btn_back=(Button)findViewById(R.id.btn_back);
            btn_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(kiloActivity.this, ilaclarActivity.class);
                    startActivity(intent);
                }
            });

            edt_Kilo = (EditText) findViewById(R.id.edt_Kilo);
            userData1 = UserData1.getInstance();

            btn_Kilo_hesapla = (Button) findViewById(R.id.btn_Kilo_hesapla);
            btn_Kilo_hesapla.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    userData1.setUserInput(edt_Kilo.getText().toString());
                    double kilo = Double.parseDouble(edt_Kilo.getText().toString());

                    userData = UserData.getInstance();
                    double ates = Double.parseDouble(userData.getUserInput());

                    double onerilenDoz = kilo * ates / 100;

                    double maxDoz = (kilo * ates / 100) + 1.8;






                    Intent intent = new Intent(kiloActivity.this, sonucActivity.class);
                    intent.putExtra("onerilen",onerilenDoz);
                    intent.putExtra("max", maxDoz);
                    startActivity(intent);
                }
            });


        }
    }




