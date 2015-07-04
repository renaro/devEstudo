package com.movile.seriestracker.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movile.seriestracker.R;
import com.movile.seriestracker.adapter.ShowRecyclerAdapter;
import com.movile.seriestracker.listeners.OnSeasonsClicked;
import com.movile.seriestracker.presenter.ShowSeasonsPresenter;
import com.movile.seriestracker.view.ShowSeasonsView;

import java.util.ArrayList;

import model.Season;

/**
 * Created by movile on 21/06/15.
 */
public class ShowFragmentSeasons extends Fragment implements ShowSeasonsView,OnSeasonsClicked {

    public static final String EXTRA_SHOW = "show";
    private ShowSeasonsPresenter presenter;
    private RecyclerView recyclerView;


    @Override
    public void onResume (){
        super.onResume();
        Bundle data = getArguments();
        String show="";
        if(data != null){
            show= data.getString(this.EXTRA_SHOW);

        }
        presenter = new ShowSeasonsPresenter(this,show);
        presenter.get();

    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.show_fragment_seasons,null);

         recyclerView = (RecyclerView)view.findViewById(R.id.seasons_recycler_view);
         recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

         return view;

    }


    @Override
    public void onSeasonsLoaded(ArrayList<Season> seasons) {
        ShowRecyclerAdapter adapter = new ShowRecyclerAdapter(seasons,this,getActivity());
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onSeasonsClicked(Season season) {


    }
}
