package com.movile.seriestracker.listeners;

import java.util.ArrayList;

import model.Episode;

/**
 * Created by movile on 21/06/15.
 */
public interface  OnEpisodeListLoaded {

    public void onListLoaded(ArrayList<Episode> ep);

}
