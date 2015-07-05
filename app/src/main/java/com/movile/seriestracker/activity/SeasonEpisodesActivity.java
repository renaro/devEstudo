package com.movile.seriestracker.activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.movile.seriestracker.R;
import com.movile.seriestracker.adapter.SeasonListAdapter;
import com.movile.seriestracker.listeners.OnEpisodeClickListener;
import com.movile.seriestracker.presenter.SeasonEpisodesPresenter;
import com.movile.seriestracker.view.SeasonEpisodesView;

import java.util.ArrayList;

import model.Episode;
import model.Images;

/**
 * Created by movile on 20/06/15.
 */
public class SeasonEpisodesActivity extends BaseNavigationToolbarActivity implements SeasonEpisodesView , OnEpisodeClickListener{

    SeasonEpisodesPresenter presenter;
    SeasonListAdapter adapter;
    public final static String SHOW_EXTRA="SHOW";
    public final static String SEASON_EXTRA="SEASON";
    private String mShow;
    private int mSeason;
    private ImageView imgBackground;
    private ImageView imgThumb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.season_episodes);
        configureToolbar();

        ListView view = (ListView) findViewById(R.id.seasonListView);
        LayoutInflater inflater = getLayoutInflater();
        View header = inflater.inflate(R.layout.season_detail_header, null);
        view.addHeaderView(header);
        imgBackground=(ImageView)header.findViewById(R.id.seasonImageGradient);
        imgThumb=(ImageView)header.findViewById(R.id.seasonImagePlaceholder);

        adapter = new SeasonListAdapter(this,this);
        view.setAdapter(adapter);
        getShowId();
        presenter = new SeasonEpisodesPresenter(this,mShow,mSeason);
        presenter.getList();



    }

    private void getShowId() {
        Intent data = getIntent();
        mShow = data.getStringExtra(this.SHOW_EXTRA);
        mSeason =(int)data.getLongExtra(this.SEASON_EXTRA,1);
    }
    @Override
    public void onEpisodeListLoaded(ArrayList<Episode> list) {
        adapter.setEpisodes(list);
        adapter.notifyDataSetChanged();

        Glide.with(this)
                .load(list.get(0).images().screenshot().get(Images.ImageSize.FULL))
                .centerCrop()
                .into(imgBackground);

        Glide.with(this)
                .load(list.get(0).images().screenshot().get(Images.ImageSize.THUMB))
                .centerCrop()
                .into(imgThumb);

    }


    @Override
    public void episodeClick(Episode ep) {

        Intent intent = new Intent(this,EpisodeDetailsActivity.class);
        intent.putExtra(EpisodeDetailsActivity.EXTRA_SHOW,mShow);
        intent.putExtra(EpisodeDetailsActivity.EXTRA_SEASON,ep.season().intValue());
        intent.putExtra(EpisodeDetailsActivity.EXTRA_EPISODE,(int)ep.number().intValue());
        startActivity(intent);
    }
}
