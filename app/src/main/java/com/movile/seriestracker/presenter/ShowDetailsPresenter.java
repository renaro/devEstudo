package com.movile.seriestracker.presenter;

import android.app.LoaderManager;
import android.content.Context;

import com.movile.seriestracker.listeners.OnFavoriteLoaded;
import com.movile.seriestracker.listeners.OnShowLoaded;
import com.movile.seriestracker.loader.DbCallBack;
import com.movile.seriestracker.remote.client.ShowDetailsRemoteClient;
import com.movile.seriestracker.view.ShowDetailsView;

import model.Favorite;
import model.Show;

/**
 * Created by movile on 21/06/15.
 */
public class ShowDetailsPresenter implements OnShowLoaded,OnFavoriteLoaded{

    private  String mShow;
    private  String mTitle;
    private ShowDetailsView mView;

    public ShowDetailsPresenter(ShowDetailsView view,String show,String title){
        mView = view;
        mShow=show;
        mTitle=title;
    }
    public void get(){
        new ShowDetailsRemoteClient(mShow,this);

    }
    public void isFavorite(Context ctx, LoaderManager loaderManager){
        DbCallBack callBack = new DbCallBack(ctx,this,mShow,mTitle,1);
        loaderManager.initLoader(0,null,callBack).forceLoad();


    }

    public void setFavorite( Context ctx, LoaderManager loaderManager){

        DbCallBack callBack = new DbCallBack(ctx,this,mShow,mTitle,2);
        loaderManager.initLoader(1,null,callBack).forceLoad();

    }

    public void removeFavorite( Context ctx, LoaderManager loaderManager){

        DbCallBack callBack = new DbCallBack(ctx,this,mShow,mTitle,3);
        loaderManager.initLoader(2,null,callBack).forceLoad();

    }

    @Override
    public void onLoaded(Show show) {
        mView.onShowLoaded(show);
    }

    @Override
    public void onFavoriteLoaded(Favorite favorite) {
    mView.onFavoriteLoaded(favorite!=null);
    }
}
