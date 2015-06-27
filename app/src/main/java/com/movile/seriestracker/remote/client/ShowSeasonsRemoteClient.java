package com.movile.seriestracker.remote.client;

import android.util.Log;

import com.movile.seriestracker.listeners.OnSeasonsLoaded;
import com.movile.seriestracker.remote.service.ShowSeasonsService;

import java.util.ArrayList;

import model.Season;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by movile on 27/06/15.
 */
public class ShowSeasonsRemoteClient {
    private final RestAdapter mAdapter;

    public ShowSeasonsRemoteClient(String mShow, final OnSeasonsLoaded showSeasonsPresenter) {

        mAdapter = new RestAdapter.Builder().setEndpoint("https://api-v2launch.trakt.tv").build();
        ShowSeasonsService service = mAdapter.create(ShowSeasonsService.class);

        service.getShowSeasons(mShow, new Callback<ArrayList<Season>>() {
            @Override
            public void success(ArrayList<Season> list, Response response) {
                showSeasonsPresenter.onSeasonsLoaded(list);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("ERRO", "Error fetching episode", error.getCause());
            }
        });




    }
}
