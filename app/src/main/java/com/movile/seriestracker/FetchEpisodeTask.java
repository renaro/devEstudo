package com.movile.seriestracker;

/**
 * Created by movile on 14/06/15.
 */

        import android.content.AsyncTaskLoader;
        import android.content.Context;

        import model.Episode;

/**
 * Created by movile on 14/06/15.
 */
public class FetchEpisodeTask extends AsyncTaskLoader<Episode> {


    private  Context ctx;
    private  OnEpisodeLoaded callback;
    private  String url;

    public FetchEpisodeTask(Context ctx,String url, OnEpisodeLoaded callback){
        super(ctx);
        this.ctx = ctx;
        this.callback = callback;
        this.url=url;


    }

    @Override
    public Episode loadInBackground() {

        new FetchEpisodeDetails(this.url).get();

return null;
    }
}
