package com.movile.seriestracker.presenter;

import com.movile.seriestracker.listeners.OnEpisodeListLoaded;
import com.movile.seriestracker.remote.client.EpisodeListRemoteClient;
import com.movile.seriestracker.view.SeasonEpisodesView;

import java.util.ArrayList;

import model.Episode;

/**
 * Created by movile on 21/06/15.
 */
public class SeasonEpisodesPresenter implements OnEpisodeListLoaded {


    private  String mShow;
    private  int mEpisode;
    private  SeasonEpisodesView mView;

    public SeasonEpisodesPresenter (SeasonEpisodesView view,String show,int episode){
        mView = view;
        mEpisode=episode;
        mShow=show;


    }

    public void getList(){
        new EpisodeListRemoteClient(mShow,mEpisode,this);

    }


    @Override
    public void onListLoaded(ArrayList<Episode> ep) {
        mView.onEpisodeListLoaded(ep);

    }
}
