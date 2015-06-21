package com.movile.seriestracker.remote.client;

import android.util.Log;

import com.movile.seriestracker.listeners.OnShowLoaded;
import com.movile.seriestracker.remote.service.ShowService;

import model.Show;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by movile on 21/06/15.
 */
public class ShowDetailsRemoteClient {

    private final RestAdapter mAdapter;

    public ShowDetailsRemoteClient(String show,final OnShowLoaded callback){

        mAdapter = new RestAdapter.Builder().setEndpoint("https://api-v2launch.trakt.tv").build();
        ShowService service = mAdapter.create(ShowService.class);
        service.getShow(show, new Callback<Show>() {
            @Override
            public void success(Show show, Response response) {
                callback.onLoaded(show);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("ERRO", "Error fetching episode", error.getCause());
            }
        });




    }
}
