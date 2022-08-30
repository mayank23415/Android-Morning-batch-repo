package in.nareshit.newsinshort;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "https://inshortsapi.vercel.app/news?category=entertainment";
    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
    }

    public void getNews(View view) {
        // Task is to get data from the url and display it on the textview that is scrollable
        progressBar.setVisibility(View.VISIBLE);
        new FetchNews(this,recyclerView,progressBar).execute(URL);
    }

    // TODO 1: after the designing part, Do Create a class that extends to AsyncTask class

}