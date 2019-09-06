package com.ronisuryadi.moviecatalogue.ui.tv;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ronisuryadi.moviecatalogue.R;
import com.ronisuryadi.moviecatalogue.data.TvEntity;
import com.ronisuryadi.moviecatalogue.ui.detail.tv.DetailTvActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvViewHolder> {
    //Deklarasi Activity
    private final Activity activity;

    //Deklarasi mTvs dengan type data list yang berisikan TvEntity
    private List<TvEntity> mTvs = new ArrayList<>();

    //Constructor TvAdapter dengan Parameter activity
    TvAdapter(Activity activity) {
        this.activity = activity;
    }

    //Fungsi ambil data list tv
    public List<TvEntity>getListTvs(){
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
    public TvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_tv, parent,false);
        return new TvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvViewHolder holder, int position) {
        Picasso.with(holder.itemView.getContext()).load(getListTvs().get(position).getPhoto()).centerCrop().fit().into(holder.imgMovie);

        holder.tvName.setText(getListTvs().get(position).getName());
        holder.tvDescription.setText(getListTvs().get(position).getDescription());

        holder.rating.setRating((float)getListTvs().get(position).getRating());

        holder.tvEpisode.setText(getListTvs().get(position).getEpisode());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailTvActivity.class);
                intent.putExtra(DetailTvActivity.EXTRA_DATA, getListTvs().get(position).getId());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListTvs().size();
    }

    public class TvViewHolder extends RecyclerView.ViewHolder {

        final TextView tvName;
        final TextView tvEpisode;
        final TextView tvDescription;
        final ImageView imgMovie;
        final RatingBar rating;

        public TvViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvEpisode = itemView.findViewById(R.id.tvEpisode);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            imgMovie = itemView.findViewById(R.id.img_photo);
            rating = itemView.findViewById(R.id.rating);
        }
    }
}
