package com.movile.seriestracker.presenter;

import com.movile.seriestracker.activity.EpisodeDetailsActivity;
import com.movile.seriestracker.listeners.OnEpisodeLoaded;
import com.movile.seriestracker.remote.client.EpisodeRemoteClient;
import com.movile.seriestracker.view.EpisodeDetailsView;

import model.Episode;

/**
 * Created by movile on 20/06/15.
 */
public class EpisodeDetailsPresenter implements OnEpisodeLoaded {
    private  String mShow;
    private  int mSeason;
    private  int mEpisode;
    private EpisodeDetailsView mView;



    public EpisodeDetailsPresenter(EpisodeDetailsActivity view, String show, int season, int episode) {
        this.mView=view;
        mShow=show;
        mSeason=season;
        mEpisode=episode;
    }


    public void get(){
        new EpisodeRemoteClient(mShow,mSeason,mEpisode,this);
    }


    @Override
    public void onLoaded(Episode episode) {
        mView.onEpisodeLoaded(episode);
    }
}
