package com.ronisuryadi.moviecatalogue.ui.tv;

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
import com.ronisuryadi.moviecatalogue.data.TvEntity;

import java.util.List;

public class TvFragment extends Fragment {
    private TvViewModel viewModel;
    private RecyclerView rvTv;
    private TvAdapter tvAdapter;
    private List<TvEntity> tvs;

    public TvFragment() {

    }
    public static Fragment newInstance(){
        return new TvFragment();
    }

    private TvViewModel movieViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTv = view.findViewById(R.id.rv_tv);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity() != null){
            viewModel = ViewModelProviders.of(this).get(TvViewModel.class);
            tvs = viewModel.getTvs();

            tvAdapter = new TvAdapter(getActivity());
            tvAdapter.setListTvs(tvs);

            rvTv.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTv.setHasFixedSize(true);
            rvTv.setAdapter(tvAdapter);
        }
    }
}