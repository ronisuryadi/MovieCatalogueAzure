package com.ronisuryadi.moviecatalogue.ui.tv;

import com.ronisuryadi.moviecatalogue.data.TvEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TvViewModelTest {
    private TvViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new TvViewModel();
    }

    @Test
    public void getMovies() {
        List<TvEntity> tvEntities = viewModel.getTvs();
        assertNotNull(tvEntities);
        assertEquals(10, tvEntities.size());
    }
}