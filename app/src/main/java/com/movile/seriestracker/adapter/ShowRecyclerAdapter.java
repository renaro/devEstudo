package com.movile.seriestracker.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.movile.seriestracker.R;
import com.movile.seriestracker.listeners.OnSeasonsClicked;

import java.util.ArrayList;

import model.Images;
import model.Season;

/**
 * Created by movile on 27/06/15.
 */
public class ShowRecyclerAdapter extends RecyclerView.Adapter<ShowRecyclerAdapter.ViewHolder> {

    private final Context ctx;
    private final OnSeasonsClicked listener;
    private ArrayList<Season> list;

    public ShowRecyclerAdapter(ArrayList<Season> list,OnSeasonsClicked listener, Context ctx) {
        this.list = list;
        this.ctx=ctx;
        this.listener=listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.season_card_view, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final Season season= getSeason(i);
        viewHolder.textTitle.setText("Season "+season.number());
        viewHolder.textQuantityEpisodes.setText(season.episodeCount()+" episodes");
        Glide.with(ctx)
                .load(season.images().poster().get(Images.ImageSize.FULL))
                .centerCrop()
                .into(viewHolder.image);
        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSeasonsClicked(season);
            }
        });

    }


    public Season getSeason(int position){
        return list.get(position);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView textTitle;
        public TextView textQuantityEpisodes;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.seasonCardImageView);
            textTitle = (TextView) itemView.findViewById(R.id.seasonCardTitle);
            textQuantityEpisodes = (TextView) itemView.findViewById(R.id.seasonCardQuantityEpisodes);

        }
    }


}
