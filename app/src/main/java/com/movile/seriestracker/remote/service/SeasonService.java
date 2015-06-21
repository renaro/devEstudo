package com.movile.seriestracker.remote.service;

import java.util.ArrayList;

import model.Episode;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import util.ApiConfiguration;

/**
 * Created by movile on 21/06/15.
 */
public interface SeasonService {

    @Headers({
            "trakt-api-version: " + ApiConfiguration.API_VERSION,
            "trakt-api-key: " + ApiConfiguration.API_KEY
    })
    @GET("/shows/{show}/seasons/{season}?extended=full,images")
    void getSeasonEpisodes(
            @Path("show") String show,
            @Path("season") Long season,
            Callback<ArrayList<Episode>> callback);
}
