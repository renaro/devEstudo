package com.movile.seriestracker.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.movile.seriestracker.DAO.FavoriteEntity;
import com.movile.seriestracker.R;
import com.movile.seriestracker.adapter.FavoriteAdapter;
import com.movile.seriestracker.listeners.OnFavoriteClicked;
import com.movile.seriestracker.presenter.FavoritePresenter;
import com.movile.seriestracker.view.FavoritesView;

/**
 * Created by movile on 05/07/15.
 */
public class FavoritesFragment extends Fragment implements FavoritesView,OnFavoriteClicked{

    private FavoritePresenter presenter;
    private FavoriteAdapter adapter;
    ListView listView;
    private ImageView imgHeader;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         View root = inflater.inflate(R.layout.favorites_layout, container, false);
        listView = (ListView)root.findViewById(R.id.favorite_list);
        imgHeader=(ImageView)root.findViewById(R.id.imageTv);

    return root;

    }


    @Override
    public void onResume() {
        super.onResume();
        presenter=new FavoritePresenter(this);
        presenter.getFavorites(getActivity(), getActivity().getLoaderManager());




    }

    @Override
    public void onFavoritesLoaded(Cursor favorites) {
        adapter=new FavoriteAdapter(getActivity(),favorites,this);
        listView.setAdapter(adapter);
        if(favorites.getCount() == 0){
            imgHeader.setImageResource(R.drawable.favorites_header_tv_unhappy);
        }






    }

    @Override
    public void onFavoriteClicked(FavoriteEntity show) {


        Intent intent = new Intent(getActivity(),ShowDetailsActivity.class);
        intent.putExtra(ShowDetailsActivity.SHOW_EXTRA,show.getSlug());
        intent.putExtra(ShowDetailsActivity.TITLE_EXTRA,show.getTitle());
        startActivity(intent);
    }
}
