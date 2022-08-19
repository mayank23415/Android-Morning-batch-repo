package in.nareshit.favoritemovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.icu.lang.UCharacter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int[] posters;
    String mTitles[], lActors[];
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildData();
        recyclerView = findViewById(R.id.recyclerview);
        MoviesAdapter moviesAdapter = new MoviesAdapter(this,posters,mTitles,lActors);
        recyclerView.setAdapter(moviesAdapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
    }

    private void buildData() {
        posters = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
        R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j};
        mTitles = new String[]{"Awe","Bad boys","Cargo","Double Dhamal","Eega","f3","Golmal Again","Hero","Iron Man","Jurassic Park"};
        lActors = new String[]{"Kajal Agarwal","Will Smith","Martin Freeman","Sanjay Dutt","Samantha","Venkatesh","Ajay Devgan","Siva Karthikeyan","Robert Downey Jr","Samuel L jackson"};
    }
}

// TODO 1: get the data ready
//  - Images
//  - Movie titles
//  - Lead Actor Names

// Todo 2: Add RecyclerView to the Project and Connect it

// TODO 3: Create a layout file to define the style of each item on the recyclerview.

// TODO 4: Create an Adapter (That holds the ViewHolder) and Populate data.

// TODO 5: Set the LayoutManager on RecyclerView