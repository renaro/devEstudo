package com.movile.seriestracker.listeners;

import com.movile.seriestracker.DAO.FavoriteEntity;

/**
 * Created by movile on 05/07/15.
 */
public interface OnFavoriteClicked {
    public void onFavoriteClicked(FavoriteEntity slug);
}
