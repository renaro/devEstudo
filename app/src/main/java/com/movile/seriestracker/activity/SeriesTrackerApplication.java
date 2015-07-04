package com.movile.seriestracker.activity;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by movile on 04/07/15.
 */
public class SeriesTrackerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }
}
