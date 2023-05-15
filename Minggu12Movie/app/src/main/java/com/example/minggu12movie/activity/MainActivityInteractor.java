package com.example.minggu12movie.activity;

import com.example.minggu12movie.api.ApiClient;
import com.example.minggu12movie.model.Movie;
import com.example.minggu12movie.model.MovieResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityInteractor {

    private ArrayList<Movie> movieList;
    private ApiClient apiClient;
    private String errorMsg;
    private String mcategory;

    public interface onAppStartedListener{
        void onApiSuccess();
        void onApiFailed();
    }

    // ini pake getter boleh ga ya?
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String getCategory() {
        return mcategory;
    }

    void getApiData(String category, final onAppStartedListener listener){
        apiClient = new ApiClient();

        Call<MovieResult> call = apiClient.endpoint().getMovies(category);

        call.enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
                movieList = response.body().getMovieList();
                mcategory = category;
                listener.onApiSuccess();
            }

            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {
                errorMsg = t.getMessage();
                listener.onApiFailed();
            }
        });

    }


}
