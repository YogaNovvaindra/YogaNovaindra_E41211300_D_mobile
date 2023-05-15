package com.example.minggu12movie.api;

import com.example.minggu12movie.model.Movie;
import com.example.minggu12movie.model.MovieResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiEndpoint {

    @GET("3/movie/{category}?api_key=b456fd8da00340cb36b7fcae5d0273af")
    Call<MovieResult> getMovies(@Path(value = "category",encoded = true) String category);

    @GET("3/movie/{id}?api_key=b456fd8da00340cb36b7fcae5d0273af&append_to_response=videos")
    Call<Movie> getMovieById(@Path(value = "id",encoded = true) String movieId);

    @GET("3/movie/{movieid}/recommendations?api_key=b456fd8da00340cb36b7fcae5d0273af&language=en-US&page=1")
    Call<MovieResult> getReccomendations(@Path(value = "movieid",encoded = true) String movieId);

}
