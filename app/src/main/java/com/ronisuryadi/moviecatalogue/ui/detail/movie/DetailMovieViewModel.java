package com.ronisuryadi.moviecatalogue.ui.detail.movie;

import com.ronisuryadi.moviecatalogue.data.MovieEntity;
import com.ronisuryadi.moviecatalogue.utils.DataDummy;

import java.util.List;

import androidx.lifecycle.ViewModel;

public class DetailMovieViewModel extends ViewModel {
    private MovieEntity mMovie;
    private int movieId;

    public MovieEntity getMovie(int movieId) {
        for (int i = 0; i < DataDummy.generateDummyMovie().size(); i++) {

            MovieEntity movieEntity = DataDummy.generateDummyMovie().get(i);
            if (movieEntity.getId() == movieId) {
                mMovie = movieEntity;
            }
        }
        return mMovie;
    }

    public List<MovieEntity> getMovies() {
        return DataDummy.generateDummyMovie();
    }
}
