package in.nareshit.viewandviewgroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

    // To Attach(inflate) a menu file to an activity - We need to override
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Get the options menu items to action

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.first_item:
                count = 0;
                score.setText(String.valueOf(count));
                break;
            case R.id.second_item:
                Toast.makeText(this, "Second is CLICKED!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.third_item:
                Toast.makeText(this, "Third is CLICKED!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fourth_item:
                Toast.makeText(this, "Fourth is CLICKED!", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Some Menu item is CLICKED!", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}