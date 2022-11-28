package com.if3b.implicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

        EditText etWebsite, etLokasi, etText;
        Button btnWebsite ,btnLokasi, btnText ,btnPindah;
        protected void onCreate(Bundle savedInstanceState) {
            //getSupportActionBar().setTitle("Implicit Cuba cuba");
            getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPindah = findViewById(R.id.btn_pindah);

        btnWebsite = findViewById(R.id.btn_buka_website);
        etWebsite = findViewById(R.id.et_website);

        btnLokasi = findViewById(R.id.btn_lokasi);
        etLokasi = findViewById(R.id.et_lokasi);

        btnText = findViewById(R.id.btn_bagitext);
        etText = findViewById(R.id.et_bagitext);

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = etWebsite.getText().toString();
                Uri urilink = Uri.parse(link);
                Intent bukaWebsite = new Intent(Intent.ACTION_VIEW, urilink);

                try {
                    startActivity(bukaWebsite);
                } catch (Exception e){
                    Toast.makeText(MainActivity.this,"Link Harus Di Isi",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lokasi = etLokasi.getText().toString();
                Uri uriLokasi = Uri.parse("geo:0,0?q="+lokasi);
                Intent bukaLokasi = new Intent(Intent.ACTION_VIEW,uriLokasi);
                startActivity(bukaLokasi);
            }
        });

        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teks = etText.getText().toString();
                String mimeType = "text/plain";
                new ShareCompat
                        .IntentBuilder(MainActivity.this)
                        .setType(mimeType)
                        .setChooserTitle("Bagikan Teks ini")
                        .setText(teks)
                        .startChooser();
            }
        });

        btnPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent pindah = new Intent(MainActivity.this,secondActivity.class);
                    startActivity(pindah);
            }
        });
    }
}