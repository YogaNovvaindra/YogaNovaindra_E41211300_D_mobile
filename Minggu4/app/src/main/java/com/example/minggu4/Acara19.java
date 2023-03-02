package com.example.minggu4;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Acara19 extends AppCompatActivity {
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara19);

        btn1 = findViewById(R.id.btnfirstFragment);
        btn2 = findViewById(R.id.btnsecondFragment);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Acara19_firstFragment());

                Toast.makeText(com.example.minggu4.Acara19.this, "ini adalah fragment pertama", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Acara19_secondFragment());

                Toast.makeText(com.example.minggu4.Acara19.this, "ini adalah fragment kedua", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadFragment(Acara19_firstFragment firstFragmentActivity) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, new Acara19_firstFragment());
        ft.commit();
    }

    private void loadFragment(Acara19_secondFragment firstFragmentActivity) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, new Acara19_secondFragment());
        ft.commit();
    }
}