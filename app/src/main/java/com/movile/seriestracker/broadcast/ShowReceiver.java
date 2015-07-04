package com.movile.seriestracker.broadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.movile.seriestracker.R;
import com.movile.seriestracker.activity.ShowDetailsActivity;

import java.util.Date;

import util.FormatUtil;

/**
 * Created by movile on 28/06/15.
 */
public class ShowReceiver extends BroadcastReceiver {

    private static final String PREFERENCES_NAME = "UPDATES";
    private static final String KEY_LAST_UPDATE = "LAST_UPDATE";

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent != null){
            Bundle extras = intent.getExtras();
            String slug = extras.getString("id");
            String title = extras.getString("title");
            String message = extras.getString("message");
            String newDate = extras.getString("date");
            Boolean alert=false;



            SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
            String last_update= preferences.getString(KEY_LAST_UPDATE, null);

            Date lastUpdate = FormatUtil.formatDate(last_update);
            Date lastUpdateReceived = FormatUtil.formatDate(newDate);



            if(last_update == null || lastUpdateReceived.after(lastUpdate) ){
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(KEY_LAST_UPDATE, newDate);
                editor.commit();
                Intent newIntent = new Intent(context,ShowDetailsActivity.class);
                newIntent.putExtra(ShowDetailsActivity.SHOW_EXTRA,slug);
                newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
                stackBuilder.addParentStack(ShowDetailsActivity.class);
                stackBuilder.addNextIntent(newIntent);


                PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);


                NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(message));

                Notification notification = builder.build();


                NotificationManager manager =
                        (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

                manager.notify(0, notification);

            } else Toast.makeText(context,"NAO NOTIFICA",Toast.LENGTH_SHORT);
        }

    }

}
