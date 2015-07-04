package com.movile.seriestracker.service;

import android.app.IntentService;
import android.content.Intent;

import com.movile.seriestracker.remote.service.UpdateShow;

import model.ShowUpdate;
import retrofit.RestAdapter;
import util.ApiConfiguration;

/**
 * Created by movile on 28/06/15.
 */
public class ServiceShowUpdates extends IntentService {


    public ServiceShowUpdates() {
        super(ServiceShowUpdates.class.getName());

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        RestAdapter mAdapter = new RestAdapter.Builder().setEndpoint(ApiConfiguration.FIREBASE_URL).build();
        UpdateShow service = mAdapter.create(UpdateShow.class);
        ShowUpdate show= service.getLatest();
        Intent sendBroadCast = new Intent("com.movile.seriestracker.action.SHOW_UPDATE");
        sendBroadCast.putExtra("title",show.title());
        sendBroadCast.putExtra("message",show.message());
        sendBroadCast.putExtra("id",show.show());
        sendBroadCast.putExtra("date",show.date());
        sendBroadcast(sendBroadCast);

    }


}
