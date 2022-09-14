package in.nareshit.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

public class PowerReceiverBroadcast extends BroadcastReceiver {

    ImageView img;

    public PowerReceiverBroadcast(ImageView img) {
        this.img = img;
    }

    // OnReceive method is the method that gets invoked as soon as we receive the broadcast.
    // Intent brings in the kind of broadcast that is invoking the onReceive(....) and also brings in
    // data along with it. you can access the data using getData(..) method on top of intent
    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case Intent.ACTION_POWER_CONNECTED:
                img.setImageResource(R.drawable.ic_baseline_battery_charging_full_24);
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                img.setImageResource(R.drawable.ic_baseline_battery_alert_24);
                break;
        }
    }
}
