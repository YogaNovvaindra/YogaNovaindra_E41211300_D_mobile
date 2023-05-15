package com.example.minggu12movie.activity;

import com.example.minggu12movie.api.ApiClient;
import com.example.minggu12movie.model.Movie;
import com.example.minggu12movie.model.MovieResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailInteractor {
    ApiClient apiClient;
    Movie movie;
    ArrayList<Movie> recommendations;
    String errorMsg;

    public interface onMovieClickedListener{
        void onApiSuccess();
        void onApiFailed();
    }

    public ArrayList<Movie> getRecommendations() {
        return recommendations;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void getMovieById(String movieId, final onMovieClickedListener listener){

        apiClient = new ApiClient();

        Call<Movie> call = apiClient.endpoint().getMovieById(movieId);

        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                movie = response.body();
                listener.onApiSuccess();
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                errorMsg = t.getMessage();
                listener.onApiFailed();
            }
        });
    }

    public void getMovieReccomendation(String movieId, final onMovieClickedListener listener){

        apiClient = new ApiClient();

        Call<MovieResult> call = apiClient.endpoint().getReccomendations(movieId);

        call.enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
                recommendations = response.body().getMovieList();
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
