package com.movile.seriestracker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.movile.seriestracker.R;
import com.movile.seriestracker.listeners.OnEpisodeClickListener;

import java.util.ArrayList;

import model.Episode;

/**
 * Created by movile on 21/06/15.
 */
public class SeasonListAdapter extends ArrayAdapter<Episode> {

    OnEpisodeClickListener mListener;
    ArrayList<Episode> mEpisodes;

    public SeasonListAdapter(Context context,OnEpisodeClickListener listener) {
        super(context,R.layout.season_episode_item);
        mListener=listener;
    }


    public void setEpisodes(ArrayList<Episode> episodes){
        mEpisodes=episodes;

    }

    @Override
    public int getCount() {
        if(mEpisodes !=null){
            return mEpisodes.size();
        }
        return 0;
    }

    @Override
    public Episode getItem(int position) {
         if(mEpisodes !=null){
            return mEpisodes.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view ==  null){
            int resource = R.layout.season_episode_item;
            view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        else{
             holder = (ViewHolder) view.getTag();
        }

        populateFromHolder(position,holder);
        return view;

    }

    private void populateFromHolder(int position, ViewHolder holder) {
        final Episode ep = getItem(position);
        holder.getEpisodeNumber().setText("E"+ep.number());
        holder.getEpisodeTitle().setText(ep.title());
        holder.mRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.episodeClick(ep);
            }
        });



    }


    public int getViewTypeCount() {
        return 1;
    }

    public int getItemViewType(int position) { return 1; }


    public  class ViewHolder {
        private TextView mEpisodeNumber;
        private TextView mEpisodeTitle;
        private View mRoot;

        public ViewHolder(View root) {
            mEpisodeNumber = (TextView) root.findViewById(R.id.seasonEpisodeNumber);
            mEpisodeTitle = (TextView) root.findViewById(R.id.seasonEpisodeTitle);
            mRoot = root;
        }

        public TextView getEpisodeTitle() {
            return mEpisodeTitle;
        }

        public TextView getEpisodeNumber() {
            return mEpisodeNumber;
        }

    }


}