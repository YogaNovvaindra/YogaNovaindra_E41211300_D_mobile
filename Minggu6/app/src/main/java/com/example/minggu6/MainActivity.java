package com.example.minggu6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button14, button15;

    private void initComponent() {
        button14  = findViewById(R.id.button_26);
        button15  = findViewById(R.id.button_28);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();

        button14.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,Acara26.class);
            startActivity(intent);
        });
        button15.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Acara28.class);
            startActivity(intent);
        });
    }
}