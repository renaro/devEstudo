package com.movile.seriestracker.remote.client;

import android.util.Log;

import com.movile.seriestracker.listeners.OnEpisodeLoaded;
import com.movile.seriestracker.remote.service.EpisodeService;

import model.Episode;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by movile on 20/06/15.
 */
public class EpisodeRemoteClient {


    private final RestAdapter mAdapter;

    public EpisodeRemoteClient(String show, int season, int episode, final OnEpisodeLoaded callback){

        mAdapter = new RestAdapter.Builder().setEndpoint("https://api-v2launch.trakt.tv").build();
        EpisodeService service = mAdapter.create(EpisodeService.class);
        Log.d("teste","teste");
        service.getEpisodeDetails(show,(long)season,(long)episode, new Callback<Episode>() {
            @Override
            public void success(Episode episode, Response response) {
                callback.onLoaded(episode);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("ERRO", "Error fetching episode", error.getCause());
            }
        });




    }


}
