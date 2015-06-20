package com.movile.seriestracker.presenter;

import com.movile.seriestracker.OnEpisodeLoaded;
import com.movile.seriestracker.remote.client.EpisodeRemoteClient;
import com.movile.seriestracker.view.EpisodeDetailsView;

import model.Episode;

/**
 * Created by movile on 20/06/15.
 */
public class EpisodeDetailsPresenter implements OnEpisodeLoaded {
    private EpisodeDetailsView mView;

    public EpisodeDetailsPresenter(EpisodeDetailsView view){
        this.mView=view;

    }

    public void get(){
        new EpisodeRemoteClient(3,this);
    }


    @Override
    public void onLoaded(Episode episode) {
        mView.onEpisodeLoaded(episode);
    }
}
