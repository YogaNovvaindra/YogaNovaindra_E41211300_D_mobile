package com.example.minggu12movie.activity;

import com.example.minggu12movie.model.Movie;

import java.util.ArrayList;

public interface MainActivityView {
    // method yang berhubungan dengan UI
    void setAdapter(ArrayList<Movie> movieArrayList,String category);
    void setErrorMsg(String errorMsg);
    void navigateToDetailPage(String movieId);
}
