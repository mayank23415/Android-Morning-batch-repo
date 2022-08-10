package in.nareshit.intentsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView mResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mResult = findViewById(R.id.data_holder);

        // TODO: Extract the data out of the Intent Object
        Intent intent = getIntent();
        String s = intent.getStringExtra("KEY");
        mResult.setText(s);
    }
}