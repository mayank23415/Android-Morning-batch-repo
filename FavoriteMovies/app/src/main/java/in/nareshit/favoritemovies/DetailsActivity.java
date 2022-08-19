package in.nareshit.favoritemovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView mn,an;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView = findViewById(R.id.movie_details_poster);
        mn = findViewById(R.id.movie_name_tv);
        an = findViewById(R.id.artist_name_tv);

        Intent i = getIntent();
        int poster = i.getIntExtra("POSTER",0);
        String mname = i.getStringExtra("MOVIE");
        String artist = i.getStringExtra("ARTIST");

        imageView.setImageResource(poster);
        mn.setText(mname);
        an.setText(artist);
    }
}