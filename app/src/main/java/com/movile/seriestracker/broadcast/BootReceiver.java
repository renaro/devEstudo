package com.movile.seriestracker.broadcast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.movile.seriestracker.service.ServiceShowUpdates;

/**
 * Created by movile on 28/06/15.
 */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("DENTRO DO BOOT", "Oo");
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, new Intent(context, ServiceShowUpdates.class), 0);
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        manager.setRepeating(AlarmManager.RTC_WAKEUP, 0, 10*1000, pendingIntent);


    }
}
