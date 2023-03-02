package com.example.minggu4;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Acara18 extends AppCompatActivity {
    private Button btnFragment1 , btnFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara18);

        btnFragment1 = findViewById(R.id.btnfirstFragment);
        btnFragment2 = findViewById(R.id.btnsecondFragment);

        btnFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new Acara18_firstFragment());
                ft.commit();

                    Toast.makeText(Acara18.this, "ini adalah fragment pertama", Toast.LENGTH_SHORT).show();


            }
        });
        btnFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new Acara18_secondFragment());
                ft.commit();

                Toast.makeText(Acara18.this, "ini adalah fragment kedua", Toast.LENGTH_SHORT).show();
            }
        });

    }



}