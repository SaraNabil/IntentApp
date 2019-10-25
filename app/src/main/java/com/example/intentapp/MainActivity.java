package com.example.intentapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView dataTv;
    public static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText dataEt = findViewById(R.id.dataEt);
        Button sendBtn = findViewById(R.id.sendBtn);
        Button openActivityBtn = findViewById(R.id.openActivityBtn);
        Button viewBtn = findViewById(R.id.viewBtn);
        dataTv = findViewById(R.id.dataTv);

        //explicit intent

        //not retrieving data
        openActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("data", dataEt.getText().toString().trim());
                startActivity(intent);

            }
        });

        //retrieving data
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("data", dataEt.getText().toString().trim());
                startActivityForResult(intent, REQUEST_CODE);

            }
        });

        //implicit intent
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            dataTv.setText(data.getStringExtra("data"));
        }
    }
}
