package com.ronisuryadi.moviecatalogue.ui.detail.tv;

import com.ronisuryadi.moviecatalogue.data.TvEntity;
import com.ronisuryadi.moviecatalogue.utils.DataDummy;

import java.util.List;

import androidx.lifecycle.ViewModel;

public class DetailTvViewModel extends ViewModel {
    private TvEntity mMovie;
    private int tvId;

    public TvEntity getTv(int tvId) {
        for (int i = 0; i < DataDummy.generateDummyTv().size(); i++) {

            TvEntity tvEntity = DataDummy.generateDummyTv().get(i);
            if (tvEntity.getId() == tvId) {
                mMovie = tvEntity;
            }
        }
        return mMovie;
    }

    public List<TvEntity> getTvs() {
        return DataDummy.generateDummyTv();
    }
}

