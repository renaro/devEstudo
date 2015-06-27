package com.movile.seriestracker.remote.client;

import android.util.Log;

import com.movile.seriestracker.listeners.OnShowListLoaded;
import com.movile.seriestracker.remote.service.ShowListService;

import java.util.ArrayList;

import model.Show;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by movile on 27/06/15.
 */
public class ShowListRemoteClient {
    private final RestAdapter mAdapter;

    public ShowListRemoteClient(final OnShowListLoaded listener) {

        mAdapter = new RestAdapter.Builder().setEndpoint("https://api-v2launch.trakt.tv").build();
        ShowListService service = mAdapter.create(ShowListService.class);
        service.getShowList(new Callback<ArrayList<Show>>() {
            @Override
            public void success(ArrayList<Show> list, Response response) {
                listener.onShowListLoaded(list);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("ERRO", "Error fetching episode", error.getCause());
            }
        });

    }
}



