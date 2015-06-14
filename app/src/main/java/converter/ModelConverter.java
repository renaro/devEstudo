package converter;

/**
 * Created by movile on 14/06/15.
 */

import com.google.gson.Gson;

import java.io.Reader;

import model.Episode;
import model.Season;
import model.Show;

public class ModelConverter {

    private Gson mGson;

    public ModelConverter() {
        mGson = new Gson();
    }

    public Episode toEpisode(Reader reader) {
        return mGson.fromJson(reader, Episode.class);
    }

    public Show toShow(Reader reader) {
        return null;
    }

    public Season toSeason(Reader reader) {
        return null;
    }

}