package in.nareshtechnologies.boundservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BoundService extends Service {

    // Base Interface for communication
    private final IBinder myBinder = new MyLocalBinder();

    public BoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myBinder;
    }

    class MyLocalBinder extends Binder{
        BoundService getService(){
            return BoundService.this;
        }
    }

    // After writing the above basic set up for letting the service and another app component
    // to do the IPC(Inter process communication)
    // Create your actual service.
    // The following service would get the system time
    public String getCurrentTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MMM/yyyy", Locale.US);
        return (dateFormat.format(new Date()));
    }

}