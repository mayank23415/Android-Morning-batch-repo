package in.nareshit.savinginstancestate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mScore;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScore = findViewById(R.id.score_tv);
        if(savedInstanceState!=null && savedInstanceState.containsKey("COUNT")){
            count = savedInstanceState.getInt("COUNT");
            mScore.setText(String.valueOf(count));
        }
    }

    public void incrementScore(View view) {
        count++;
        mScore.setText(String.valueOf(count));
    }

    // When the screen rotation happens save the count data
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT",count);
    }
}