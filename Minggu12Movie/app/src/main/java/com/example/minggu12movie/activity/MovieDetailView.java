package com.example.minggu12movie.activity;

import com.example.minggu12movie.model.Movie;

import java.util.ArrayList;

public interface MovieDetailView {

    // method yang ingin diimplementasikan di activity
    void setDetails(Movie movie);
    void setErrorMsg(String text);
    void setAdapter(ArrayList<Movie> movieArrayList);
}
