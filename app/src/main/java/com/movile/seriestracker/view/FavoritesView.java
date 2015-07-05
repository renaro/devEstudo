package com.movile.seriestracker.view;

import android.database.Cursor;

/**
 * Created by movile on 05/07/15.
 */
public interface FavoritesView {

    public void onFavoritesLoaded(Cursor favorites);
}
