package in.nareshit.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // after executing oncreate(...) your activity is sent to CREATED State
        // All start up initializations happen here
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MAIN","onCreate()");
    }

    @Override
    protected void onStart() {
        // Activity start up logic - goes here
        // The activity is now VISIBLE to the user but not interactable.
        super.onStart();
        Log.d("MAIN","onStart()");
    }

    @Override
    protected void onResume() {
        // Your activity is now interactable
        super.onResume();
        Log.d("MAIN","onResume()");
    }

    @Override
    protected void onPause() {
        // After executing onPause(...), the activity will no longer be visible
        super.onPause();
        Log.d("MAIN","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MAIN","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MAIN","onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MAIN","onRestart()");
    }
}