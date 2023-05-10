package com.example.minggu12movie.activity;

import android.content.Intent;

import com.example.minggu12movie.activity.MovieDetail;
import com.example.minggu12movie.api.ApiClient;
import com.example.minggu12movie.model.Movie;
import com.example.minggu12movie.model.MovieResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityPresenter implements MainActivityInteractor.onAppStartedListener{

    private MainActivityView view;
    private MainActivityInteractor interactor;


    public MainActivityPresenter(MainActivityView view, MainActivityInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void updateMovieData(String category){
        interactor.getApiData(category,this);
    }

    @Override
    public void onApiSuccess() {
        if (view != null){
            view.setAdapter(interactor.getMovieList(),interactor.getCategory());
        }
    }

    @Override
    public void onApiFailed() {
        if (view != null){
            view.setErrorMsg(interactor.getErrorMsg());
        }
    }

}
