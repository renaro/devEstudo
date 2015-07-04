package com.movile.seriestracker.remote.service;

import model.ShowUpdate;
import retrofit.http.GET;

/**
 * Created by movile on 28/06/15.
 */
public interface UpdateShow {


        @GET("/latestUpdate.json")
        ShowUpdate getLatest();


}
