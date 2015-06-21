package com.movile.seriestracker.remote.client;

import android.util.Log;

import com.movile.seriestracker.listeners.OnEpisodeListLoaded;
import com.movile.seriestracker.remote.service.SeasonService;

import java.util.ArrayList;

import model.Episode;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by movile on 21/06/15.
 */
public class EpisodeListRemoteClient {

    private final RestAdapter mAdapter;

    public EpisodeListRemoteClient(String show,int season, final OnEpisodeListLoaded callback){

        mAdapter = new RestAdapter.Builder().setEndpoint("https://api-v2launch.trakt.tv").build();
        SeasonService service = mAdapter.create(SeasonService.class);
        service.getSeasonEpisodes(show, (long)season, new Callback<ArrayList<Episode>>() {
            @Override
            public void success(ArrayList<Episode> list, Response response) {
                callback.onListLoaded(list);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("ERRO", "Error fetching episode", error.getCause());
            }
        });




    }


}
