package com.example.minggu12json.adapters;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.minggu12json.MovieDetails;
import com.example.minggu12json.R;

public class Popular_view_holder  extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView imageView_pop;
    RatingBar ratingBar_pop;
    OnMovieListener listener;

    public Popular_view_holder(@NonNull View itemView, OnMovieListener listener) {
        super(itemView);

        this.listener = listener;
        imageView_pop = itemView.findViewById(R.id.movie_img_popualar);
        ratingBar_pop = itemView.findViewById(R.id.rating_bar_pop);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
