package com.farjihan.hitungnilaiquis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nilai_tugas, nilai_quis, nilai_uts, nilai_uas;
    Button hitung, bersih;
    TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nilai_tugas = (EditText) findViewById(R.id.nilai_tugas);
        nilai_quis = (EditText) findViewById(R.id.nilai_quis);
        nilai_uts = (EditText) findViewById(R.id.nilai_uts);
        nilai_uas = (EditText) findViewById(R.id.nilai_uas);


        bersih = (Button) findViewById(R.id.bersih);
        hitung = (Button) findViewById(R.id.hitung);

        hasil = (TextView) findViewById(R.id.hasil);

        hitung.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if((nilai_tugas.getText().length()>0) && (nilai_quis.getText().length()>0) && (nilai_uts.getText().length()>0) && (nilai_uas.getText().length()>0))
                {
                    double tugas = Double.parseDouble(nilai_tugas.getText().toString());
                    double quis = Double.parseDouble(nilai_quis.getText().toString());
                    double uts = Double.parseDouble(nilai_uts.getText().toString());
                    double uas = Double.parseDouble(nilai_uas.getText().toString());

                    double result = (tugas * 60 / 100) + (quis * 60 / 100) + (uts * 60 / 100) + (uas * 60 / 100);
                    hasil.setText(Double.toString(result));
                }
                else {
                    Toast toast = Toast.makeText(MainActivity.this, "Mohon masukkan Semua Nilai", Toast.LENGTH_LONG);
                    toast.show();
        }}
        });

        bersih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai_tugas.setText("");
                nilai_quis.setText("");
                nilai_uts.setText("");
                nilai_uas.setText("");
                hasil.setText("");
                nilai_tugas.requestFocus();
            }
        });
    }
}
