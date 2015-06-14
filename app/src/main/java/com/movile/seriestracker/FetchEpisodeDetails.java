package com.movile.seriestracker;

import android.content.Context;

import java.net.HttpURLConnection;

/**
 * Created by movile on 14/06/15.
 */
public class FetchEpisodeDetails {
    public FetchEpisodeDetails(String url) {


        HttpURLConnection connection = null;



    }


    private HttpURLConnection configureConnection(Context ctx, String url){
/*
        HttpURLConnection connection=(HttpURLConnection) new URL(url).openConnection();;

        connection.setReadTimeout(READ_TIMEOUT);
        connection.setConnectTimeout(CONNECTION_TIMEOUT);
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("trakt-api-version", API_VERSION);
        connection.setRequestProperty("trakt-api-key", API_KEY);
*/
        return null;
    }

    public void get() {

    }
}
