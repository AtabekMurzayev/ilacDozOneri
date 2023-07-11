package com.nexis.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;
import android.text.TextWatcher;
import android.text.Editable;


public class MainActivity extends AppCompatActivity {
    private Button btn_sonraki;
    private Button btn_atesKaydet;
    private EditText edtTxtAtesGirirs;
    private UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*edtTxtAtesGirirs.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // İlgilenmediğimiz metot
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // İlgilenmediğimiz metot
            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString().trim();
                btn_sonraki.setEnabled(!input.isEmpty());
            }
        });*/

        edtTxtAtesGirirs=(EditText)findViewById(R.id.edtTxtAtesGirirs);
        userData = UserData.getInstance();
        btn_atesKaydet=(Button) findViewById(R.id.btn_atesKaydet);
        btn_atesKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkUserInput();
            }
        });

        btn_sonraki=(Button) findViewById(R.id.btn_sonraki);
        btn_sonraki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = edtTxtAtesGirirs.getText().toString();
                userData.setUserInput(userInput);

                Intent intent = new Intent(MainActivity.this, ilaclarActivity.class);
                startActivity(intent);
            }
        });

    }
    private void checkUserInput() {
        String userInput = edtTxtAtesGirirs.getText().toString().trim();

        if (TextUtils.isEmpty(userInput)) {
            showAlertDialog("Uyarı", "Girdi boş olamaz, Değerler38.5 ve 41.5 arasında olmalıdır!");
        } else if (userInput.length() < 6) {
            showAlertDialog("Uyarı", "!Çocuğunuzun ateşi girildi");
        } else {
            // Doğru giriş durumunda yapılacak işlemler
            showAlertDialog("Başarılı", "Giriş doğrulandı!");
        }
    }
    private void showAlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Tamam butonuna tıklandığında yapılacak işlemler
                    }
                })
                .show();
    }
}