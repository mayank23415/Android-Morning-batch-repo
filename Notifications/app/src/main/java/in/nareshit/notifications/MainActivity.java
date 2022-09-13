package in.nareshit.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final int NOTIFICATION_ID = 456;
    public static final int PENDING_INTENT_REQ = 6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNotification(View view) {
        // To create and manage notifications we need a Notification Manager
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // TODO : Send Notification
        // TODO 1: First Create a NotificationChannel (for all the versions >= 8.0)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // here you need to create Notification Channel
            NotificationChannel channel = new NotificationChannel("pavan","Naresh Tech",
                    NotificationManager.IMPORTANCE_HIGH);

            manager.createNotificationChannel(channel);
        }
        // the rest of the code remains same for all the devices
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"pavan");
        //set the icon of the notification
        builder.setSmallIcon(R.drawable.ic_baseline_back_hand_24);
        //set the title of the notification
        builder.setContentTitle("A Sample Notification");
        //set the message of the notification
        builder.setContentText("This is the small description of the notification");
        // set the priority for all the devices that run less than 8.0
        builder.setPriority(NotificationCompat.PRIORITY_MAX);
        //to send the notification, use manager object and call notify method
        // Step 1 is to define an Intent object with the action we want
        // Step 2 is to wrap this intent in a pending intent object
        // step 3 attach this pending intent object to the notification
        Intent i = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,PENDING_INTENT_REQ,i,PendingIntent.FLAG_IMMUTABLE);
        builder.setContentIntent(pi);
        builder.setAutoCancel(true);
        manager.notify(NOTIFICATION_ID,builder.build());
    }
}