package in.nareshit.viewandviewgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect "score" with "result" textview on the xml file
        score = findViewById(R.id.result);
    }

    // This Method will increment the score and display it to the user
    public void incrementScore(View view) {
        count++;
        score.setText(String.valueOf(count));
    }

    // This Method will decrement the score and display it to the user
    public void decrementScore(View view) {
        count--;
        score.setText(String.valueOf(count));
    }
}