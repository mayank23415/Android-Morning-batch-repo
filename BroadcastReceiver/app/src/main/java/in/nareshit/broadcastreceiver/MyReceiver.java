package in.nareshit.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    TextView tv;

    public MyReceiver(TextView tv) {
        this.tv = tv;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction() == MainActivity.CUSTOM_BROADCAST){
            tv.setText("CUSTOM BROADCAST FROM OTHER APP\n is received");
        }
    }
}