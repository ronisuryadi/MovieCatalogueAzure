package com.ronisuryadi.moviecatalogue.ui.detail.tv;

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
import com.ronisuryadi.moviecatalogue.data.TvEntity;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

public class DetailTvActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "extra_data";

    private ImageView imgMovie;
    private TextView txtName;
    private TextView txtEpisode;
    private TextView txtDescription;
    private TextView txtGenre;
    private TextView txtRelease;
    private RatingBar rbRating;

    private RecyclerView rvTv;

    private DetailTvAdapter adapter;

    private DetailTvViewModel viewModel;

    private ScrollView scScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgMovie = findViewById(R.id.movie_photo);
        txtName = findViewById(R.id.tvTvName);
        txtEpisode = findViewById(R.id.tvEpisode);
        txtDescription = findViewById(R.id.tvDescription);
        txtGenre = findViewById(R.id.tvGenre);
        txtRelease = findViewById(R.id.tvRelease);
        rbRating = findViewById(R.id.ratings);
        scScrollView = findViewById(R.id.scroll_view_detail);

        rvTv = findViewById(R.id.rv_tv_popular);

        viewModel = ViewModelProviders.of(this).get(DetailTvViewModel.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int tvId = extras.getInt(EXTRA_DATA);
            if (tvId != 0) {
                //viewModel.setMovieId(movieId);
                populateTv(viewModel.getTv(tvId));
            }
        }

        List<TvEntity> mtvs = viewModel.getTvs();
        adapter = new DetailTvAdapter(this);
        Collections.shuffle(mtvs);
        adapter.setListTvs(mtvs);

        rvTv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        rvTv.setHasFixedSize(true);
        rvTv.setAdapter(adapter);

        scScrollView.smoothScrollTo(0,0); //set it on top

    }

    private void populateTv(TvEntity tvEntity) {
        getSupportActionBar().setTitle(tvEntity.getName());
        txtName.setText(tvEntity.getName());
        txtEpisode.setText(tvEntity.getEpisode());
        txtDescription.setText(tvEntity.getDescription());

        txtGenre.setText(tvEntity.getGenre());
        txtRelease.setText(tvEntity.getRelease());
        rbRating.setRating((float)tvEntity.getRating());

        Picasso.with(getApplicationContext()).load(tvEntity.getPhoto()).fit().into(imgMovie);
    }
}
