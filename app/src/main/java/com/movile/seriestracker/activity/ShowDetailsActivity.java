package com.movile.seriestracker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.movile.seriestracker.R;
import com.movile.seriestracker.adapter.ShowViewPageAdapter;
import com.movile.seriestracker.presenter.ShowDetailsPresenter;
import com.movile.seriestracker.view.ShowDetailsView;

import model.Images;
import model.Show;

/**
 * Created by movile on 21/06/15.
 */
public class ShowDetailsActivity extends BaseNavigationToolbarActivity implements ShowDetailsView{

    private ViewPager mViewPager;
    private ShowDetailsPresenter presenter;
    private ImageView showImage;
    private TextView showRating;
    private TextView showTitle;
    public final static String SHOW_EXTRA="SHOW";
    private String mShowName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_details);
        configureToolbar();
        getShowId();

        mViewPager=(ViewPager)findViewById(R.id.show_details_content);
        showImage=(ImageView)findViewById(R.id.serieImageFragment);
        showRating=(TextView)findViewById(R.id.showScore);
        showTitle=(TextView)findViewById(R.id.showTitle);

        presenter = new ShowDetailsPresenter(this,mShowName);
        presenter.get();
   //






    }

    private void getShowId() {
        Intent data = getIntent();
        mShowName = data.getStringExtra(this.SHOW_EXTRA);
    }

    @Override
    public void onShowLoaded(Show show) {

       ShowViewPageAdapter adapter = new ShowViewPageAdapter(getSupportFragmentManager(),show);
        mViewPager.setAdapter(adapter);
        showRating.setText(" " + show.rating());
        showTitle.setText(show.title());
        Glide.with(this)
                .load(show.images().poster().get(Images.ImageSize.FULL))
                .centerCrop()
                .into(showImage);


    }
}
