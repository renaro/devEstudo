package com.movile.seriestracker.presenter;

import com.movile.seriestracker.listeners.OnShowListLoaded;
import com.movile.seriestracker.remote.client.ShowListRemoteClient;
import com.movile.seriestracker.view.ShowView;

import java.util.ArrayList;

import model.Show;

/**
 * Created by movile on 27/06/15.
 */
public class ShowPresenter implements OnShowListLoaded {


    private final ShowView view;

    public ShowPresenter(ShowView view) {
        this.view=view;
    }

    public void getList(){
        new ShowListRemoteClient(this);

    }

    @Override
    public void onShowListLoaded(ArrayList<Show> list) {
    view.onShowLoaded(list);
    }
}
