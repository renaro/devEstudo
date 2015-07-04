package com.movile.seriestracker.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.movile.seriestracker.DAO.FavoriteDAO;

import model.Favorite;

/**
 * Created by movile on 04/07/15.
 */
public class FavoriteDbLoader extends AsyncTaskLoader<Favorite> {

    private final Integer mAction;
    private Context mCtx;
    private String mSlug;
    private FavoriteDAO dao;
    private String mTitle;

    public FavoriteDbLoader(Integer action,Context ctx,String slug,String title) {
        super(ctx);
        mCtx = ctx;
        mSlug=slug;
        mAction=action;
        mTitle=title;
        dao=new FavoriteDAO(ctx);
    }


    @Override
    public Favorite loadInBackground() {

        switch (mAction){
            case 1:
                return dao.query(mSlug);

            case 2:
                Favorite fav = new Favorite(mTitle,mSlug);
                dao.save(fav);
                return fav;
            case 3:
                dao.delete(mSlug);
                return null;

            default:
                return null;

        }

    }


}