package com.example.minggu3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class acara15_main extends AppCompatActivity {
    private MahasiswaAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Mahasiswa> mahasiswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acara15_layout);
        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new MahasiswaAdapter(mahasiswaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(acara15_main.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
    void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("Huda", "E41211492", "08123456769"));
        mahasiswaArrayList.add(new Mahasiswa("Nurul Hudi", "E41211493", "08123457789"));
        mahasiswaArrayList.add(new Mahasiswa("Nurul", "E41211494", "08123456489"));
        mahasiswaArrayList.add(new Mahasiswa("Salwi", "E41211495", "08123456289"));
        mahasiswaArrayList.add(new Mahasiswa("Gita", "E41211496", "08123456789"));
        mahasiswaArrayList.add(new Mahasiswa("Nail", "E41211497", "08123456789"));
        mahasiswaArrayList.add(new Mahasiswa("Huda", "E41211492", "08123456769"));
        mahasiswaArrayList.add(new Mahasiswa("Nurul Hadi", "E41211493", "08123457789"));
        mahasiswaArrayList.add(new Mahasiswa("Nurul", "E41211494", "08123456489"));
        mahasiswaArrayList.add(new Mahasiswa("Salli", "E41211495", "08123456289"));
        mahasiswaArrayList.add(new Mahasiswa("Gita", "E41211496", "08123456789"));

    }
}