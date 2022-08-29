package in.nareshit.newsinshort;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "https://inshortsapi.vercel.app/news?category=entertainment";
    TextView tv;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.result);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
    }

    public void getNews(View view) {
        // Task is to get data from the url and display it on the textview that is scrollable
        progressBar.setVisibility(View.VISIBLE);
        new FetchNews(this,tv,progressBar).execute(URL);
    }

    // TODO 1: after the designing part, Do Create a class that extends to AsyncTask class

}