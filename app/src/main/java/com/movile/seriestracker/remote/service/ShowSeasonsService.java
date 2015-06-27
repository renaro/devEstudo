package com.movile.seriestracker.remote.service;

import java.util.ArrayList;

import model.Season;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import util.ApiConfiguration;

/**
 * Created by movile on 27/06/15.
 */

    public interface ShowSeasonsService {
        @Headers({
                "trakt-api-version: " + ApiConfiguration.API_VERSION,
                "trakt-api-key: " + ApiConfiguration.API_KEY
        })
        @GET("/shows/{show}/seasons/?extended=full,images")
        void getShowSeasons(
                @Path("show") String show,
                Callback<ArrayList<Season>> callback);
    }

