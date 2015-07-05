package com.movile.seriestracker.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.movile.seriestracker.DAO.FavoriteEntity;
import com.movile.seriestracker.DAO.FavoriteEntity$Adapter;
import com.movile.seriestracker.R;
import com.movile.seriestracker.listeners.OnFavoriteClicked;

/**
 * Created by movile on 05/07/15.
 */
public class FavoriteAdapter  extends CursorAdapter{

    private final OnFavoriteClicked mListener;

    public FavoriteAdapter(Context context, Cursor c, OnFavoriteClicked listener) {
        super(context, c);
        mListener=listener;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.favorite_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);
        return view;

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        FavoriteEntity$Adapter entity$Adapter = new FavoriteEntity$Adapter();
        final FavoriteEntity entity = new FavoriteEntity();
        entity$Adapter.loadFromCursor(cursor,entity);
        viewHolder.setTitle(entity.getTitle());
        viewHolder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFavoriteClicked(entity);
            }
        });



    }

    public class ViewHolder {

        public TextView title;
        public View root;

        public ViewHolder(View view) {
            title=(TextView)view.findViewById(R.id.favoriteTitle);
            root=view;
        }
        public void setTitle(String favoriteTitle){
            title.setText(favoriteTitle);
        }
    }
}
