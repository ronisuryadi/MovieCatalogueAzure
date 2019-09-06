package com.ronisuryadi.moviecatalogue.ui.movie;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ronisuryadi.moviecatalogue.R;
import com.ronisuryadi.moviecatalogue.data.MovieEntity;
import com.ronisuryadi.moviecatalogue.ui.detail.movie.DetailMovieActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    //Deklarasi Activity
    private final Activity activity;
    //Deklarasi mMovies dengan type data list yang berisikan MovieEntity
    private List<MovieEntity> mMovies = new ArrayList<>();

    //Constructor MovieAdapter dengan Parameter activity
    MovieAdapter(Activity activity) {
        this.activity = activity;
    }

    //Fungsi ambil data list movie
    public List<MovieEntity>getListMovies(){
        return mMovies;
    }

    //Fungi set List
    void setListMovies(List<MovieEntity> listMovies){
        if(listMovies == null) return;
        this.mMovies.clear();
        this.mMovies.addAll(listMovies);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_movie, parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Picasso.with(holder.itemView.getContext()).load(getListMovies().get(position).getPhoto()).centerCrop().fit().into(holder.imgMovie);

        holder.tvName.setText(getListMovies().get(position).getName());
        holder.tvDescription.setText(getListMovies().get(position).getDescription());

        holder.rating.setRating(getListMovies().get(position).getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_DATA, getListMovies().get(position).getId());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListMovies().size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        final TextView tvName;
        final TextView tvDescription;
        final ImageView imgMovie;
        final RatingBar rating;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            imgMovie = itemView.findViewById(R.id.img_photo);
            rating = itemView.findViewById(R.id.rating);
        }
    }
}
