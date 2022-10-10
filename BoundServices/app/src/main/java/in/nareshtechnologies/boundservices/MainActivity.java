package in.nareshtechnologies.boundservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BoundService myService;
    boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this,BoundService.class);
        //bind a service
        bindService(intent,myConnection,BIND_AUTO_CREATE);
    }

    public void getTime(View view) {
        Toast.makeText(myService, myService.getCurrentTime(), Toast.LENGTH_SHORT).show();
    }

    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BoundService.MyLocalBinder binder = (BoundService.MyLocalBinder) iBinder;
            myService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // to unbind a service
        unbindService(myConnection);
    }
}