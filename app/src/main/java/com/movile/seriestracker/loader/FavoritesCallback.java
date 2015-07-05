package com.movile.seriestracker.loader;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;

import com.movile.seriestracker.listeners.OnFavoritesLoaded;

/**
 * Created by movile on 05/07/15.
 */
public class FavoritesCallback implements LoaderManager.LoaderCallbacks<Cursor> {

    private final OnFavoritesLoaded mListener;
    private final Context mContext;

    public FavoritesCallback(OnFavoritesLoaded listener,Context context){
        mListener=listener;
        mContext=context;

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
       return new FavoritesLoader(mContext);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mListener.onFavoritesLoaded(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
