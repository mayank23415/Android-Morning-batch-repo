package in.nareshit.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // to Override the default functionality of the back button, we can use the following method
    @Override
    public void onBackPressed() {
        // to override the functionality remove super.onBackPressed()
        /*super.onBackPressed();*/
        showAlert2();
    }

    public void showAlert(View view){
        showAlert2();
    }

    public void showAlert2() {
        
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogCustom);
        // To set title
        builder.setTitle("This is a Sample Title");
        // To Set Message
        builder.setMessage("This is a message of good length");
        // to set an ICON
        builder.setIcon(R.drawable.ic_baseline_bike_scooter_24);

        // Three Buttons can be placed at most on the alert box.
        // - Positive Button, Negative Button, Neutral Button
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "No is pressed!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("cancel",null);

        // The following show() method must be called at the last.
        builder.show();
    }
}