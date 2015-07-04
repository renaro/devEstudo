package com.movile.seriestracker.loader;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;

import com.movile.seriestracker.listeners.OnFavoriteLoaded;

import model.Favorite;

/**
 * Created by movile on 04/07/15.
 */
public class DbCallBack  implements LoaderManager.LoaderCallbacks<Favorite> {


    private final OnFavoriteLoaded mListener;
    private  Context mCtx;
    private  String mSlug;
    private  int mAction;
    private String mTitle;


    public DbCallBack(Context ctx,OnFavoriteLoaded listener,String slug,String title,int action) {
        mCtx=ctx;
        mListener=listener;
        mSlug=slug;
        mAction=action;
        mTitle=title;

    }


    public Loader<Favorite> onCreateLoader(int id, Bundle bundle) {
        return new FavoriteDbLoader(mAction,mCtx,mSlug,mTitle);

        }

        public void onLoadFinished(Loader<Favorite> loader, Favorite result) {
            mListener.onFavoriteLoaded(result);

        }

        public void onLoaderReset(Loader<Favorite> loader) {


        }
    }

