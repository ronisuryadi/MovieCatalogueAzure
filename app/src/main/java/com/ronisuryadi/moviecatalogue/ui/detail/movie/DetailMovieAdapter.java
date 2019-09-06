package com.ronisuryadi.moviecatalogue.ui.detail.movie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ronisuryadi.moviecatalogue.R;
import com.ronisuryadi.moviecatalogue.data.MovieEntity;
import com.ronisuryadi.moviecatalogue.ui.movie.MovieAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DetailMovieAdapter extends  RecyclerView.Adapter<DetailMovieAdapter.DetailMovieViewAdapter>{
    private Context context;
    private List<MovieEntity> mMovies;

    public DetailMovieAdapter(Context context) {
        this.context = context;
        mMovies = new ArrayList<>();
    }

    //Fungsi Get Data
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
    public DetailMovieViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items_movie_popular, parent,false);
        return new DetailMovieViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailMovieViewAdapter holder, int position) {
        Picasso.with(holder.itemView.getContext()).load(getListMovies().get(position).getPhoto()).centerCrop().fit().into(holder.imgMovie);

        holder.imgMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_DATA, getListMovies().get(position).getId());
                context.startActivity(intent);
                ((Activity)context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListMovies().size();
    }

    public class DetailMovieViewAdapter extends RecyclerView.ViewHolder {
        final ImageView imgMovie;

        public DetailMovieViewAdapter(@NonNull View itemView) {
            super(itemView);
            imgMovie = itemView.findViewById(R.id.movie_photo2);
        }
    }
}
