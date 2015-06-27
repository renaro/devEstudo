package com.movile.seriestracker.presenter;

import com.movile.seriestracker.listeners.OnSeasonsLoaded;
import com.movile.seriestracker.remote.client.ShowSeasonsRemoteClient;
import com.movile.seriestracker.view.ShowSeasonsView;

import java.util.ArrayList;

import model.Season;

/**
 * Created by movile on 27/06/15.
 */
public class ShowSeasonsPresenter implements OnSeasonsLoaded {


    private final ShowSeasonsView mView;
    private final String mShow;

    public ShowSeasonsPresenter(ShowSeasonsView view, String show) {
        mView=view;
        mShow=show;

    }

    public void get() {

        new ShowSeasonsRemoteClient(mShow,this);
    }


    @Override
    public void onSeasonsLoaded(ArrayList<Season> list) {
        mView.onSeasonsLoaded(list);
    }

}
