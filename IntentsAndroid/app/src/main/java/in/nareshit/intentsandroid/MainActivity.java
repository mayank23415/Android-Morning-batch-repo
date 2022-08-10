package in.nareshit.intentsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNext(View view) {
        // TODO : Take the user from this Activity (MainActivity) to the Next Activity(SecondActivity)
        Intent i = new Intent(this,SecondActivity.class);
        // TODO: Start the Activity
        i.putExtra("KEY","Naresh IT Technologies");
        startActivity(i);
    }

    public void openBrowser(View view) {
        // This method is responsible to open the url
        EditText et = findViewById(R.id.url_et);
        String url = et.getText().toString();
        if(url.isEmpty()){
            et.setError("Have to enter a url");
        }else{
            Uri browser = Uri.parse("https://"+url);
            Intent intent = new Intent(Intent.ACTION_VIEW, browser);
            // Check if there is an application that can resolve the request
            if(intent.resolveActivity(getPackageManager())!=null){
                startActivity(intent);
            }else{
                Toast.makeText(this, "No Application to Process the Req", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void openMaps(View view) {
        // This method opens maps for us - geo:0,0?q=my+street+address (Data URI Scheme)
        EditText add = findViewById(R.id.address_et);
        String a = add.getText().toString();
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+a));
        if(i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }

    public void openDailer(View view) {
        EditText n = findViewById(R.id.phone_et);
        String p = n.getText().toString();
        Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+p));
        startActivity(i);
    }
}

// TODO: Sending some tiny data to the second activity