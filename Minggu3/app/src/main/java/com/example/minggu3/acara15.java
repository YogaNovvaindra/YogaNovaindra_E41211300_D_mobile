package com.example.minggu3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class acara15 extends AppCompatActivity {
    private acara15_mahasiswa_adapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<acara15_mahasiswa> mahasiswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara15_layout);
        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new acara15_mahasiswa_adapter(mahasiswaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(acara15.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
    void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new acara15_mahasiswa("Huda", "E41211492", "08123456769"));
        mahasiswaArrayList.add(new acara15_mahasiswa("Nurul Hudi", "E41211493", "08123457789"));
        mahasiswaArrayList.add(new acara15_mahasiswa("Nurul", "E41211494", "08123456489"));
        mahasiswaArrayList.add(new acara15_mahasiswa("Salwi", "E41211495", "08123456289"));
        mahasiswaArrayList.add(new acara15_mahasiswa("Gita", "E41211496", "08123456789"));
        mahasiswaArrayList.add(new acara15_mahasiswa("Nail", "E41211497", "08123456789"));
        mahasiswaArrayList.add(new acara15_mahasiswa("Huda", "E41211492", "08123456769"));
        mahasiswaArrayList.add(new acara15_mahasiswa("Nurul Hadi", "E41211493", "08123457789"));
        mahasiswaArrayList.add(new acara15_mahasiswa("Nurul", "E41211494", "08123456489"));
        mahasiswaArrayList.add(new acara15_mahasiswa("Salli", "E41211495", "08123456289"));
        mahasiswaArrayList.add(new acara15_mahasiswa("Gita", "E41211496", "08123456789"));

    }
}