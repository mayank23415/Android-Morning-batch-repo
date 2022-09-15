package in.nareshit.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String CUSTOM_BROADCAST = "AnyUniqueStringCanBeGivenHere";
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.message);
        IntentFilter filter = new IntentFilter(CUSTOM_BROADCAST);
        registerReceiver(new MyReceiver(tv),filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(new MyReceiver(tv));
    }
}