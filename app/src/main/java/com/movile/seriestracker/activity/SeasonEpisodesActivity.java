package com.movile.seriestracker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.movile.seriestracker.R;
import com.movile.seriestracker.adapter.SeasonListAdapter;
import com.movile.seriestracker.listeners.OnEpisodeClickListener;
import com.movile.seriestracker.presenter.SeasonEpisodesPresenter;
import com.movile.seriestracker.view.SeasonEpisodesView;

import java.util.ArrayList;

import model.Episode;

/**
 * Created by movile on 20/06/15.
 */
public class SeasonEpisodesActivity extends BaseNavigationToolbarActivity implements SeasonEpisodesView , OnEpisodeClickListener{

    SeasonEpisodesPresenter presenter;
    SeasonListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.season_episodes);
        configureToolbar();

        ListView view = (ListView) findViewById(R.id.seasonListView);
        LayoutInflater inflater = getLayoutInflater();
        View header = inflater.inflate(R.layout.season_detail_header, null);
        view.addHeaderView(header);
        adapter = new SeasonListAdapter(this,this);
        view.setAdapter(adapter);

        presenter = new SeasonEpisodesPresenter(this,"game-of-thrones",2);
        presenter.getList();



    }


    @Override
    public void onEpisodeListLoaded(ArrayList<Episode> list) {
        adapter.setEpisodes(list);
        adapter.notifyDataSetChanged();

    }


    @Override
    public void episodeClick(Episode ep) {

        Intent intent = new Intent(this,EpisodeDetailsActivity.class);
        intent.putExtra(EpisodeDetailsActivity.EXTRA_SHOW,"game-of-thrones");
        intent.putExtra(EpisodeDetailsActivity.EXTRA_SEASON,ep.season().intValue());
        intent.putExtra(EpisodeDetailsActivity.EXTRA_EPISODE,(int)ep.number().intValue());
        startActivity(intent);
    }
}
