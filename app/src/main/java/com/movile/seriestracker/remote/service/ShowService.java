package com.movile.seriestracker.remote.service;

import model.Show;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import util.ApiConfiguration;

/**
 * Created by movile on 21/06/15.
 */
public interface ShowService {
    @Headers({
            "trakt-api-version: " + ApiConfiguration.API_VERSION,
            "trakt-api-key: " + ApiConfiguration.API_KEY
    })
    @GET("/shows/{show}?extended=full,images")
    void getShow(
            @Path("show") String show,
            Callback<Show> callback);
}
