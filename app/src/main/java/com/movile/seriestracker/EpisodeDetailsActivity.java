package com.movile.seriestracker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.Episode;
import util.FormatUtil;


public class EpisodeDetailsActivity extends ActionBarActivity  implements OnEpisodeLoaded{



private TextView episode_details_tv;
private TextView episode_title_tv;
private TextView episode_date_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.episode_details_activity);

        episode_details_tv = (TextView)findViewById(R.id.cardview_summary_description_text);
        episode_title_tv = (TextView)findViewById(R.id.episode_title_text);
        episode_date_tv = (TextView)findViewById(R.id.cardview_date_text);

       new FetchLocalEpisodeTask(this,this).execute();



    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("ON RESUME---------", "");
    }

    @Override
    protected void onRestart(){
        super.onResume();
        Log.d("ON RESTART", "");
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
        outState.putInt("valor",1);
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onLoaded(Episode ep) {
        episode_details_tv.setText(ep.overview());
        episode_title_tv.setText(ep.title());
        Date date = new FormatUtil().formatDate(ep.firstAired());

        episode_date_tv.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm").format(date));

    }
}
