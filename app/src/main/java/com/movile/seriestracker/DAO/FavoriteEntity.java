package com.movile.seriestracker.DAO;

import android.provider.BaseColumns;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(databaseName = SeriesTrackerDatabase.NAME)
public class FavoriteEntity extends BaseModel {
    @Column(name = BaseColumns._ID)
    @PrimaryKey(autoincrement = true)
    Long id;

    @Column
    String mSlug;

    @Column
    String mTitle;

    public FavoriteEntity(String slug, String title) {
        mSlug=slug;
        mTitle=title;
    }
    public FavoriteEntity(){}
}