package com.movile.seriestracker;

import android.content.Context;
import android.os.AsyncTask;

import model.Episode;

/**
 * Created by movile on 14/06/15.
 */
public class FetchLocalEpisodeTask extends AsyncTask<Void,Void,Episode> {

    private Context ctx;
    private OnEpisodeLoaded listener;


    public FetchLocalEpisodeTask(Context ctx,OnEpisodeLoaded listener){
        this.ctx = ctx;
        this.listener=listener;
    }


    @Override
    protected Episode doInBackground(Void... params) {
        return new FetchLocalEpisodeDetails().get(ctx);
    }


    @Override
    protected void onPostExecute(Episode episode) {
        super.onPostExecute(episode);
        listener.onLoaded(episode);

    }
}
