package com.ronisuryadi.moviecatalogue.ui.detail.movie;

import com.ronisuryadi.moviecatalogue.R;
import com.ronisuryadi.moviecatalogue.data.MovieEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DetailMovieViewModelTest {
    private DetailMovieViewModel viewModel;
    private MovieEntity dummyMovie;

    @Before
    public void setUp() {
        viewModel = new DetailMovieViewModel();
        dummyMovie = new MovieEntity(6,
                "DragonBall",
                "Goku and Vegeta encounter Broly, a Saiyan warrior unlike any fighter they ve faced before.",
                "Animation, Action, Adventure",
                "2019",
                3,
                R.drawable.poster_dragonball);

    }

    @Test
    public void getMovie(){
        MovieEntity movieEntity = viewModel.getMovie(dummyMovie.getId());
        assertNotNull(movieEntity);

        assertEquals(dummyMovie.getId(), movieEntity.getId());
        assertEquals(dummyMovie.getName(), movieEntity.getName());
        assertEquals(dummyMovie.getDescription(), movieEntity.getDescription());
        assertEquals(dummyMovie.getGenre(), movieEntity.getGenre());
        assertEquals(dummyMovie.getRelease(), movieEntity.getRelease());
        assertEquals(dummyMovie.getPhoto(), movieEntity.getPhoto());
    }

    @Test
    public void getMovies(){
        List<MovieEntity> movieEntities = viewModel.getMovies();
        assertNotNull(movieEntities);
        assertEquals(11, movieEntities.size());
    }
}