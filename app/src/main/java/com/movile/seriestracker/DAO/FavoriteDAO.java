package com.movile.seriestracker.DAO;

import android.content.Context;
import android.database.Cursor;

import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.Select;

import model.Favorite;

/**
 * Created by movile on 04/07/15.
 */
public class FavoriteDAO {

    private Context mContext;

    public FavoriteDAO(Context context) {
        mContext = context;
    }

    public void save(Favorite favorite) {

        FavoriteEntity entity = new FavoriteEntity(favorite.getSlug(), favorite.getTitle());
        entity.save();

    }

       public Cursor all() {
         return new Select().from(FavoriteEntity.class).where().query();
       }


        public Favorite query(String slug) {

            FavoriteEntity entity = new Select()
                    .from(FavoriteEntity.class)
                    .where(Condition.column(FavoriteEntity$Table.MSLUG).eq(slug))
                    .querySingle();

            if(entity !=  null){
                return new Favorite(entity.mTitle,entity.mSlug);
            }
            return null;
        }

    public void delete(String slug) {


        new Delete()
                .from(FavoriteEntity.class)
                .where(Condition.column(FavoriteEntity$Table.MSLUG).eq(slug))
                .queryClose();
    }

}