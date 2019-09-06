package com.ronisuryadi.moviecatalogue.ui.detail.movie;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ronisuryadi.moviecatalogue.R;
import com.ronisuryadi.moviecatalogue.data.MovieEntity;
import com.ronisuryadi.moviecatalogue.ui.movie.MovieAdapter;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "extra_data";

    private ImageView imgMovie;
    private TextView txtName;
    private TextView txtDescription;
    private TextView txtGenre;
    private TextView txtRelease;
    private RatingBar rbRating;

    private RecyclerView rvMovie;

    private DetailMovieAdapter adapter;

    private DetailMovieViewModel viewModel;

    private ScrollView scScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgMovie = findViewById(R.id.movie_photo);
        txtName = findViewById(R.id.tvMovieName);
        txtDescription = findViewById(R.id.tvMovieDescription);
        txtGenre = findViewById(R.id.tvMovieGenre);
        txtRelease = findViewById(R.id.tvMovieRelease);
        rbRating = findViewById(R.id.ratings);
        scScrollView = findViewById(R.id.scroll_view_detail);

        rvMovie = findViewById(R.id.rv_movie_popular);

        viewModel = ViewModelProviders.of(this).get(DetailMovieViewModel.class);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int movieId = extras.getInt(EXTRA_DATA);
            if (movieId != 0) {
                //viewModel.setMovieId(movieId);
                populateMovie(viewModel.getMovie(movieId));
            }
        }

        List<MovieEntity> mm = viewModel.getMovies();
        adapter = new DetailMovieAdapter(this);
        Collections.shuffle(mm);
        adapter.setListMovies(mm);

        rvMovie.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvMovie.setHasFixedSize(true);
        rvMovie.setAdapter(adapter);

        scScrollView.smoothScrollTo(0,0); //set it on top

    }

    private void populateMovie(MovieEntity movieEntity) {
        System.out.println("Wow "+movieEntity.getName());
        getSupportActionBar().setTitle(movieEntity.getName());
        txtName.setText(movieEntity.getName());
        txtDescription.setText(movieEntity.getDescription());

        txtGenre.setText(movieEntity.getGenre());
        txtRelease.setText(movieEntity.getRelease());
        rbRating.setRating(movieEntity.getRating());

        Picasso.with(getApplicationContext()).load(movieEntity.getPhoto()).fit().into(imgMovie);
        /*



         */
    }
}
