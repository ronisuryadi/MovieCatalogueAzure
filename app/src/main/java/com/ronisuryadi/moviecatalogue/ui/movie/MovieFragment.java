package com.ronisuryadi.moviecatalogue.ui.movie;

import android.graphics.Movie;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ronisuryadi.moviecatalogue.R;
import com.ronisuryadi.moviecatalogue.data.MovieEntity;

import java.util.List;

public class MovieFragment extends Fragment {
    private MovieViewModel viewModel;
    private RecyclerView rvMovie;
    private MovieAdapter movieAdapter;
    private List<MovieEntity> movies;

    public MovieFragment() {

    }

    public static Fragment newInstance(){
        return new MovieFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovie = view.findViewById(R.id.rv_movie);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity() != null){
            viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
            movies = viewModel.getMovies();

            movieAdapter = new MovieAdapter(getActivity());
            movieAdapter.setListMovies(movies);

            rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            rvMovie.setHasFixedSize(true);
            rvMovie.setAdapter(movieAdapter);
        }
    }
}