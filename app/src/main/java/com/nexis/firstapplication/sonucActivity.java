package com.nexis.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import java.text.DecimalFormat;
import android.os.CountDownTimer;



public class sonucActivity extends AppCompatActivity {
    private Button btnSayac;
    private Button btn_back;

    private TextView textViewSayac;
    private TextView txtView_Ates;
    private UserData userData;
    private UserData1 userData1;
    private TextView txtView_kg;
    private TextView txtView_nasilKullanilir;
    private TextView txt_Onerilen;
    private TextView txtEnFazla;
    private TextView countdownText;

    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private long timeLeftInMillis = 1800000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);

        btn_back=(Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(sonucActivity.this, kiloActivity.class);
                startActivity(intent);
            }
        });
        txtView_Ates = (TextView) findViewById(R.id.txtView_Ates);
        textViewSayac = (TextView) findViewById(R.id.textViewSayac);
        /*btnSayac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timerRunning) {
                    stopTimer();
                } else {
                    startTimer();
                }
            }
        });*/
        btnSayac = findViewById(R.id.btnSayac);
        txtView_kg = (TextView) findViewById(R.id.txtView_kg);

        userData = UserData.getInstance();
        String userInput = userData.getUserInput();
        txtView_Ates.setText(userInput);

        userData1 = UserData1.getInstance();
        String kilo = userData1.getUserInput();
        txtView_kg.setText(kilo);

        txtView_nasilKullanilir = findViewById(R.id.txtView_nasilKullanilir);
        String fullText = "Nasıl kullanılır? Ateş düşürücü şurup şişesini homojen bir görüntü oluşana kadar 10-15saniye" +
                " çalkalayın. Önerilen hacim aralığında  enjektöre çekin ve çocuğunuza ağız yoluyla verin ";
        String boldText = "Nasıl kullanılır?";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fullText);
        StyleSpan boldStyleSpan = new StyleSpan(Typeface.BOLD_ITALIC);
        int startIndex = fullText.indexOf(boldText);
        int endIndex = startIndex + boldText.length();
        spannableStringBuilder.setSpan(boldStyleSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtView_nasilKullanilir.setText(spannableStringBuilder);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            double onerilen = extras.getDouble("onerilen");
            double max = extras.getDouble("max");

            TextView txtOnerilen = findViewById(R.id.txt_Onerilen);
            txtOnerilen.setText(String.valueOf(onerilen));

            TextView txtEnFazla = findViewById(R.id.txtEnFazla);
            txtEnFazla.setText(String.valueOf(max));
        }


    }
    /*private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                // Sayaç tamamlandığında burada yapılacak işlemleri ekleyebilirsiniz
                timerRunning = false;
                btnSayac.setText("Başlat");
            }
        }.start();

        timerRunning = true;
        btnSayac.setText("Durdur");
    }

    private void stopTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        btnSayac.setText("Başlat");
    }

    private void updateCountdownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);
        countdownText.setText(timeLeftFormatted);
    }

*/
}


