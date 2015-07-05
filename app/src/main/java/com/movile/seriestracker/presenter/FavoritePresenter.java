package com.movile.seriestracker.presenter;

import android.app.LoaderManager;
import android.content.Context;
import android.database.Cursor;

import com.movile.seriestracker.listeners.OnFavoritesLoaded;
import com.movile.seriestracker.loader.FavoritesCallback;
import com.movile.seriestracker.view.FavoritesView;

/**
 * Created by movile on 05/07/15.
 */
public class FavoritePresenter implements OnFavoritesLoaded {


    private final FavoritesView mListener;

    public FavoritePresenter(FavoritesView listener){
        mListener=listener;

    }

    public void getFavorites(Context ctx,LoaderManager loaderManager){

        FavoritesCallback callback = new FavoritesCallback(this,ctx);
        loaderManager.initLoader(0,null,callback).forceLoad();

    }



    @Override
    public void onFavoritesLoaded(Cursor favorites) {
        mListener.onFavoritesLoaded(favorites);
    }
}
