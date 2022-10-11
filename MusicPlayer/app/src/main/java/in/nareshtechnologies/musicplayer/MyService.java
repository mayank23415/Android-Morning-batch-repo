package in.nareshtechnologies.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    MediaPlayer player;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
      return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service is Created", Toast.LENGTH_SHORT).show();

        // Initialize the player object
        player = MediaPlayer.create(this,R.raw.music_song);
        player.setLooping(false); // to not loop the song - pass false, otherwise pass true.
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show();
        player.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
        player.stop();
    }
}