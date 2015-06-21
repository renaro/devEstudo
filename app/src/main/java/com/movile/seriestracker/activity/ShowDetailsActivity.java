package com.movile.seriestracker.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.movile.seriestracker.R;
import com.movile.seriestracker.adapter.ShowViewPageAdapter;
import com.movile.seriestracker.presenter.ShowDetailsPresenter;
import com.movile.seriestracker.view.ShowDetailsView;

import model.Show;

/**
 * Created by movile on 21/06/15.
 */
public class ShowDetailsActivity extends BaseNavigationToolbarActivity implements ShowDetailsView{

    private ViewPager mViewPager;
    private ShowDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_details);
        configureToolbar();

        mViewPager=(ViewPager)findViewById(R.id.show_details_content);


        presenter = new ShowDetailsPresenter(this,"game-of-thrones");
        presenter.get();
   //






    }

    @Override
    public void onShowLoaded(Show show) {
        ShowViewPageAdapter adapter = new ShowViewPageAdapter(getSupportFragmentManager(),show);
        mViewPager.setAdapter(adapter);
        Log.d(" ----->"+show.overview(),"");
    }
}
