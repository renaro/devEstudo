package com.movile.seriestracker;

/**
 * Created by movile on 14/06/15.
 */
import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import converter.ModelConverter;
import model.Episode;

public class FetchLocalEpisodeDetails {

    private static final String TAG = FetchLocalEpisodeDetails.class.getSimpleName();
    private static final String ASSET_NAME = "episode.json";

    public Episode get(Context context) {
        Episode episode = null;
        InputStreamReader reader = null;

        try {
            InputStream stream = context.getResources().getAssets().open(ASSET_NAME);
            reader = new InputStreamReader(stream);
            episode = new ModelConverter().toEpisode(reader);
        } catch (IOException e) {
            Log.e(TAG, "Error loading local content from file", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e(TAG, "Error releasing resource", e);
                }
            }
        }

        return episode;
    }

}