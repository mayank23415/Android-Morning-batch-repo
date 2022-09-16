package in.nareshit.alarmmanager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class ReminderReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("water","Hydration Reminder",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "water");
        builder.setSmallIcon(R.drawable.ic_baseline_local_drink_24);
        builder.setContentTitle("Time To DRINK!!!");
        builder.setContentText("IT's time to drink water");
        builder.setAutoCancel(true);

        manager.notify(42, builder.build());
    }
}