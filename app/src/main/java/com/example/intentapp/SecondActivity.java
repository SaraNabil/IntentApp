package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView dataTv = findViewById(R.id.dataTv);
        final EditText dataEt = findViewById(R.id.dataEt);
        Button sendBtn = findViewById(R.id.sendBtn);

        String data = getIntent().getStringExtra("data");

        dataTv.setText(data);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                intent.putExtra("data",dataEt.getText().toString().trim());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
