package com.example.minggu12movie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.minggu12movie.activity.MainActivityInteractor;
import com.example.minggu12movie.activity.MainActivityPresenter;
import com.example.minggu12movie.activity.MainActivityView;
import com.example.minggu12movie.activity.MovieDetail;
import com.example.minggu12movie.activity.MovieDetailPresenter;
import com.example.minggu12movie.model.Movie;

import java.util.ArrayList;

public class MovieDetailAdapter extends RecyclerView.Adapter<MovieDetailAdapter.MyViewHolder> {

    private ArrayList<Movie> movieArrayList;
    private Context context;


    public MovieDetailAdapter(ArrayList<Movie> movieList, Context context){
        this.movieArrayList = movieList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView movieTitle;
        TextView movieRating;
        TextView movieDesc;
        ImageView moviePoster;
        CardView cardView;
        public MyViewHolder(final View view){
            super(view);
            movieTitle = view.findViewById(R.id.movieTitle);
            movieRating = view.findViewById(R.id.movieRating);
            movieDesc = view.findViewById(R.id.movieDescription);
            moviePoster = view.findViewById(R.id.movieImage);
            cardView = view.findViewById(R.id.cardView);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_view,parent,false);
        context = parent.getContext();
        return new MyViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = movieArrayList.get(position);

        Glide.with(context).load("https://image.tmdb.org/t/p/w500/" + movie.getImg_path())
                .into(holder.moviePoster);

        holder.movieTitle.setText(movie.getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //presenter.onListViewClicked(movie.getMovieId());
                String movieId = movie.getMovieId();
                Intent intent = new Intent(context,MovieDetail.class);
                Bundle bundle = new Bundle();
                bundle.putString("ID",movieId);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }






}

