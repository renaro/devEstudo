package com.movile.seriestracker.listeners;

import android.database.Cursor;

/**
 * Created by movile on 05/07/15.
 */
public interface OnFavoritesLoaded {
    public void onFavoritesLoaded(Cursor favorites);
}
