package com.ronisuryadi.moviecatalogue.ui.detail.tv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ronisuryadi.moviecatalogue.R;
import com.ronisuryadi.moviecatalogue.data.TvEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DetailTvAdapter extends RecyclerView.Adapter<DetailTvAdapter.DetailTvViewAdapter> {
    private Context context;
    private List<TvEntity> mTvs;

    public DetailTvAdapter(Context context) {
        this.context = context;
        mTvs = new ArrayList<>();
    }

    //Fungsi Get Data
    public List<TvEntity>getListMovies(){
        return mTvs;
    }

    //Fungi set List
    void setListTvs(List<TvEntity> listTvs){
        if(listTvs == null) return;
        this.mTvs.clear();
        this.mTvs.addAll(listTvs);
    }

    @NonNull
    @Override
    public DetailTvAdapter.DetailTvViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items_tv_popular, parent,false);
        return new DetailTvViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailTvAdapter.DetailTvViewAdapter holder, int position) {
        Picasso.with(holder.itemView.getContext()).load(getListMovies().get(position).getPhoto()).centerCrop().fit().into(holder.imgTv);

        holder.imgTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailTvActivity.class);
                intent.putExtra(DetailTvActivity.EXTRA_DATA, getListMovies().get(position).getId());
                context.startActivity(intent);
                ((Activity)context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListMovies().size();
    }

    public class DetailTvViewAdapter extends RecyclerView.ViewHolder {
        final ImageView imgTv;
        public DetailTvViewAdapter(@NonNull View itemView) {
            super(itemView);

            imgTv = itemView.findViewById(R.id.tv_photo2);
        }
    }
}
