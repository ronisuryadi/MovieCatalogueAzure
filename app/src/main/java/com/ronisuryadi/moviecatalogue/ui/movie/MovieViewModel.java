package com.ronisuryadi.moviecatalogue.ui.movie;

import com.ronisuryadi.moviecatalogue.data.MovieEntity;
import com.ronisuryadi.moviecatalogue.utils.DataDummy;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MovieViewModel extends ViewModel {

    public List<MovieEntity> getMovies() {
        return DataDummy.generateDummyMovie();
    }
}