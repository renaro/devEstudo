package com.movile.seriestracker.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import com.movile.seriestracker.R;
import com.movile.seriestracker.adapter.GridAdapter;
import com.movile.seriestracker.listeners.OnShowClicked;
import com.movile.seriestracker.presenter.ShowPresenter;
import com.movile.seriestracker.view.ShowView;

import java.util.ArrayList;

import model.Show;

/**
 * Created by movile on 27/06/15.
 */
public class ShowActivity extends Activity implements ShowView ,OnShowClicked {

    private GridView grid;
    private ShowPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_grid);
        grid=(GridView)findViewById(R.id.showGrid);
        presenter = new ShowPresenter(this);
        presenter.getList();

    }

    @Override
    public void onShowLoaded(ArrayList<Show> list) {
        GridAdapter adapter = new GridAdapter(this,this,list);
        grid.setAdapter(adapter);


    }

    @Override
    public void onShowCLicked(Show show) {
        Intent intent = new Intent(this,ShowDetailsActivity.class);
        intent.putExtra(ShowDetailsActivity.SHOW_EXTRA,show.ids().slug());
        startActivity(intent);

    }
}
