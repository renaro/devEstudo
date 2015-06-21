package com.movile.seriestracker.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.movile.seriestracker.R;
import com.movile.seriestracker.presenter.EpisodeDetailsPresenter;
import com.movile.seriestracker.view.EpisodeDetailsView;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.Episode;
import model.Images;
import retrofit.RestAdapter;
import util.FormatUtil;


public class EpisodeDetailsActivity extends BaseNavigationToolbarActivity  implements EpisodeDetailsView{



    private TextView episode_details_tv;
    private TextView episode_title_tv;
    private TextView episode_date_tv;
    private ImageView episode_background;
    private EpisodeDetailsPresenter presenter;
    public static String EXTRA_SHOW = "show";
    public static String EXTRA_SEASON = "season";
    public static String EXTRA_EPISODE= "episode";
    private String mShow;
    private int mSeason;
    private int mEpisode;

    private RestAdapter mAdapter;
    private String url="https://api-v2launch.trakt.tv/shows/game-of-thrones/seasons/1/episodes/1?extended=full,images";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.episode_details_activity);
        configureToolbar();

        episode_details_tv = (TextView)findViewById(R.id.cardview_summary_description_text);
        episode_title_tv = (TextView)findViewById(R.id.episode_title_text);
        episode_date_tv = (TextView)findViewById(R.id.cardview_date_text);
        episode_background = (ImageView)findViewById(R.id.episodes_img_background);
        //request episode details


        getExtras();

        presenter = new EpisodeDetailsPresenter(this,mShow,mSeason,mEpisode);
        presenter.get();


    }
    public void getExtras() {
        Bundle input = getIntent().getExtras();
        mShow   =    input.getString(EXTRA_SHOW);
        mSeason =    input.getInt(EXTRA_SEASON,1);
        mEpisode =   input.getInt(EXTRA_EPISODE,1);
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.episode_details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("valor", 1);
        super.onSaveInstanceState(outState);

    }



    @Override
    public void onEpisodeLoaded(Episode ep) {
        if(ep!=null) {
            episode_details_tv.setText(ep.overview());
            episode_title_tv.setText(ep.title());
            Date date = new FormatUtil().formatDate(ep.firstAired());
            episode_date_tv.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm").format(date));
            Glide.with(this)
                    .load(ep.images().screenshot().get(Images.ImageSize.FULL))
                    .centerCrop()
                    .into(episode_background);

        }
    }


}
