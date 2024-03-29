package com.example.minggu12movie.model;

import com.example.minggu12movie.model.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieResult {

    @SerializedName("results")
    private ArrayList<Movie> movieList;

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }
}
