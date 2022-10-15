package com.if3b.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
        EditText etWebsite;
        Button btnWebsite;
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWebsite = findViewById(R.id.btn_buka_website);
        etWebsite = findViewById(R.id.et_website);

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = etWebsite.getText().toString();
                Intent inten = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(inten);
            }
        });
    }
}