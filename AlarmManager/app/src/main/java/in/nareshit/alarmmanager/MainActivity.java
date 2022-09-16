package in.nareshit.alarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    AlarmManager manager;
    PendingIntent pi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialise the Alarm Manager
        manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        pi = PendingIntent.getBroadcast(this, 56, new Intent(this,ReminderReceiver.class),
                PendingIntent.FLAG_IMMUTABLE);
    }

    public void sendAlarm(View view) {
        long firstTriggerTime = SystemClock.elapsedRealtime() + (60*1000);
        long intervalTime = 2*60*1000;

        manager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,
                firstTriggerTime,
                intervalTime,
                pi);
    }


    public void cancelAlarm(View view) {
        manager.cancel(pi);
    }
}