package com.example.minggu5;

import android.os.Bundle;
import android.widget.TextView;


public class IntentExplicit2 extends IntentExplicit {
    TextView txtHello;
    private String nama;
    private String KEY_NAME = "NAMA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_explicit_2);
        txtHello = (TextView) findViewById(R.id.txtHello);
        Bundle extras = getIntent().getExtras();
        nama = extras.getString(KEY_NAME);
        txtHello.setText("Hello, " + nama + " !");
    }
}
