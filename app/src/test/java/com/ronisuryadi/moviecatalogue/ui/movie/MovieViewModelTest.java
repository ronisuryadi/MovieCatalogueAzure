package com.ronisuryadi.moviecatalogue.ui.movie;

import com.ronisuryadi.moviecatalogue.data.MovieEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieViewModelTest {
    private MovieViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new MovieViewModel();
    }

    @Test
    public void getMovies() {
        List<MovieEntity> movieEntities = viewModel.getMovies();
        assertNotNull(movieEntities);
        assertEquals(11, movieEntities.size());
    }
}