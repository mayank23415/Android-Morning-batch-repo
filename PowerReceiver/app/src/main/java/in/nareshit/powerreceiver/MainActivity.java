package in.nareshit.powerreceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    IntentFilter intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.imageView);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(new PowerReceiverBroadcast(img),filter);

        intent = new IntentFilter(PowerReceiverBroadcast.CUSTOM_BROADCAST);
        /*LocalBroadcastManager.getInstance(this).registerReceiver(new PowerReceiverBroadcast(img),intent);*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(new PowerReceiverBroadcast(img));
        /*LocalBroadcastManager.getInstance(this).unregisterReceiver(new PowerReceiverBroadcast(img));*/
    }

    public void sendCustomBroadcast(View view) {
        /*LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(PowerReceiverBroadcast.CUSTOM_BROADCAST));*/
        sendBroadcast(new Intent(PowerReceiverBroadcast.CUSTOM_BROADCAST));
    }
}