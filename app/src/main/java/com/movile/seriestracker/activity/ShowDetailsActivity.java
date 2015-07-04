package com.movile.seriestracker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.view.View;
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
public class ShowDetailsActivity extends BaseNavigationToolbarActivity implements ShowDetailsView,View.OnClickListener{

    private ViewPager mViewPager;
    private ShowDetailsPresenter presenter;
    private ImageView showImage;
    private TextView showRating;
    private TextView showTitle;
    public final static String SHOW_EXTRA="SHOW";
    public final static String TITLE_EXTRA="TITLE";
    private String mShowName;
    private String mTitle;
    private FloatingActionButton fab;
    private Boolean isFavorite=false;
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
        fab=(FloatingActionButton)findViewById(R.id.show_details_favorite);

        presenter = new ShowDetailsPresenter(this,mShowName,mTitle);
        presenter.get();
        presenter.isFavorite(this, getLoaderManager());
        fab.setOnClickListener(this);
   //





    }

    private void getShowId() {
        Intent data = getIntent();
        mShowName = data.getStringExtra(this.SHOW_EXTRA);
        mTitle = data.getStringExtra(this.TITLE_EXTRA);

    }

    @Override
    public void onShowLoaded(Show show) {

       ShowViewPageAdapter adapter = new ShowViewPageAdapter(getSupportFragmentManager(),show);
        mViewPager.setAdapter(adapter);

        showRating.setText(" " + String.format("%.2f", show.rating()));
        showTitle.setText(show.title());

        Glide.with(this)
                .load(show.images().poster().get(Images.ImageSize.FULL))
                .centerCrop()
                .into(showImage);


    }

    @Override
    public void onFavoriteLoaded(boolean isFavorite_) {
        this.isFavorite=isFavorite_;

        if(isFavorite){
            fab.setImageResource(R.drawable.show_details_favorite_on);
            fab.setBackgroundTintList(getResources().getColorStateList(R.color.show_details_favorite_on));
        }else{
            fab.setImageResource(R.drawable.show_details_favorite_off);
            fab.setBackgroundTintList(getResources().getColorStateList(R.color.show_details_favorite_off));
        }



    }

    @Override
    public void onClick(View v) {
        if(v.getId() == fab.getId()){
            if(!isFavorite){
                isFavorite=true;
                fab.setImageResource(R.drawable.show_details_favorite_on);
                fab.setBackgroundTintList(getResources().getColorStateList(R.color.show_details_favorite_on));
                presenter.setFavorite(this, getLoaderManager());
            }else{
                isFavorite=false;
                fab.setImageResource(R.drawable.show_details_favorite_off);
                fab.setBackgroundTintList(getResources().getColorStateList(R.color.show_details_favorite_off));
                presenter.removeFavorite(this, getLoaderManager());
            }
        }
    }
}
