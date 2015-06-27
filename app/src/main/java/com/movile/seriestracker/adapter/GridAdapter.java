package com.movile.seriestracker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.movile.seriestracker.R;
import com.movile.seriestracker.listeners.OnShowClicked;

import java.util.ArrayList;

import model.Images;
import model.Show;

/**
 * Created by movile on 27/06/15.
 */
public class GridAdapter extends ArrayAdapter<Show>{


    private final Context context;
    private final OnShowClicked onShowCLicked;
    ArrayList<Show> mShows;

    
    public GridAdapter(Context context,OnShowClicked onShowCLicked,ArrayList<Show> list) {
        super(context, R.layout.show_image_layout);
        this.mShows=list;
        this.context=context;
        this.onShowCLicked=onShowCLicked;
    }



    @Override
    public int getCount() {
        if(mShows !=null){
            return mShows.size();
        }
        return 0;
    }

    @Override
    public Show getItem(int position) {
        if(mShows !=null){
            return mShows.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view ==  null){
            int resource = R.layout.show_image_layout;
            view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        final Show show = getItem(position);

        Glide.with(context)
                .load(show.images().poster().get(Images.ImageSize.FULL))
                .centerCrop()
                .into(holder.getImage());
        holder.getImage().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onShowCLicked.onShowCLicked(show);
            }
        });

        return view;

    }



    public  class ViewHolder {
        private ImageView mImage;
        private View mRoot;

        public ViewHolder(View root) {
            mImage = (ImageView) root.findViewById(R.id.showImageView);
            mRoot = root;
        }

        public ImageView getImage() {
            return mImage;
        }


    }

}
