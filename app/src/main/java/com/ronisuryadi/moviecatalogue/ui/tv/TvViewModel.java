package com.ronisuryadi.moviecatalogue.ui.tv;

import com.ronisuryadi.moviecatalogue.data.TvEntity;
import com.ronisuryadi.moviecatalogue.utils.DataDummy;

import java.util.List;

import androidx.lifecycle.ViewModel;

public class TvViewModel extends ViewModel {

    public List<TvEntity> getTvs() {
        return DataDummy.generateDummyTv();
    }
}

