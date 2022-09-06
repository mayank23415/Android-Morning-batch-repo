package in.nareshit.retrofitex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    CatFactService cfs;
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://meowfacts.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cfs = retrofit.create(CatFactService.class);
    }

    public void getFacts(View view) {
        progressBar.setVisibility(View.VISIBLE);
        Call<Source> call = cfs.getCatFact();
        call.enqueue(new Callback<Source>() {
            @Override
            public void onResponse(Call<Source> call, Response<Source> response) {
                Source s = response.body();
                progressBar.setVisibility(View.GONE);
                textView.setText("");
                for(String fact: s.getData()){
                    textView.append(fact+"\n");
                }
            }

            @Override
            public void onFailure(Call<Source> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this,"The data is not fetched!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}