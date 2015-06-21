package com.movile.seriestracker.presenter;

import com.movile.seriestracker.listeners.OnShowLoaded;
import com.movile.seriestracker.remote.client.ShowDetailsRemoteClient;
import com.movile.seriestracker.view.ShowDetailsView;

import model.Show;

/**
 * Created by movile on 21/06/15.
 */
public class ShowDetailsPresenter implements OnShowLoaded{

    private  String mShow;
    private ShowDetailsView mView;

    public ShowDetailsPresenter(ShowDetailsView view,String show){
        mView = view;
        mShow=show;
    }
    public void get(){
        new ShowDetailsRemoteClient(mShow,this);

    }


    @Override
    public void onLoaded(Show show) {
        mView.onShowLoaded(show);
    }
}
