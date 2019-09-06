package com.ronisuryadi.moviecatalogue.ui.detail.tv;

import com.ronisuryadi.moviecatalogue.R;
import com.ronisuryadi.moviecatalogue.data.TvEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DetailTvViewModelTest {
    private DetailTvViewModel viewModel;
    private TvEntity dummyTv;

    @Before
    public void setUp() {
        viewModel = new DetailTvViewModel();
        dummyTv = new TvEntity(3,
                "Peaky Blinders",
                "A gangster family epic set in 1919 Birmingham, England; centered on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby.",
                "Crime | Drama",
                "2014",
                "37 Episodes",
                4.4,
                R.drawable.peaky_blinders);

    }

    @Test
    public void getTv(){
        TvEntity tvEntity = viewModel.getTv(dummyTv.getId());
        assertNotNull(tvEntity);

        assertEquals(dummyTv.getId(), tvEntity.getId());
        assertEquals(dummyTv.getName(), tvEntity.getName());
        assertEquals(dummyTv.getDescription(), tvEntity.getDescription());
        assertEquals(dummyTv.getEpisode(), tvEntity.getEpisode());
        assertEquals(dummyTv.getGenre(), tvEntity.getGenre());
        assertEquals(dummyTv.getRelease(), tvEntity.getRelease());
        assertEquals(dummyTv.getPhoto(), tvEntity.getPhoto());
    }

    @Test
    public void getTvs(){
        List<TvEntity> tvEntities = viewModel.getTvs();
        assertNotNull(tvEntities);
        assertEquals(10, tvEntities.size());
    }
}