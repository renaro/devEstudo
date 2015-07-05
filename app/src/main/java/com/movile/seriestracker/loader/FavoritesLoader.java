package com.movile.seriestracker.loader;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;

import com.movile.seriestracker.DAO.FavoriteDAO;

/**
 * Created by movile on 05/07/15.
 */
public class FavoritesLoader extends CursorLoader {

    private final FavoriteDAO dao;

    private  Context mCtx;

    public FavoritesLoader(Context context) {
        super(context);
        dao=new FavoriteDAO(context);

    }


    @Override
    public Cursor loadInBackground() {
        return dao.all();
    }
}
