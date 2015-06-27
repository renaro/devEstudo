package com.movile.seriestracker.view;

import java.util.ArrayList;

import model.Season;

/**
 * Created by movile on 27/06/15.
 */
public interface ShowSeasonsView {
    public void onSeasonsLoaded(ArrayList<Season> seasons);
}
