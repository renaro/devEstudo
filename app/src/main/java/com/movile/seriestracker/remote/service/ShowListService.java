package com.movile.seriestracker.remote.service;

import java.util.ArrayList;

import model.Show;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import util.ApiConfiguration;

/**
 * Created by movile on 27/06/15.
 */
public interface ShowListService {

    @Headers({
            "trakt-api-version: " + ApiConfiguration.API_VERSION,
            "trakt-api-key: " + ApiConfiguration.API_KEY
    })
    @GET("/shows/popular?limit=50&extended=full,images")
    void getShowList(Callback<ArrayList<Show>> callback);

    }
