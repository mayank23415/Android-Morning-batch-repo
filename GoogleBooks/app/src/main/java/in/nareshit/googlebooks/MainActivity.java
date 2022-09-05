package in.nareshit.googlebooks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import in.nareshit.googlebooks.Models.Item;
import in.nareshit.googlebooks.Models.Source;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        editText = findViewById(R.id.book_name);
        textView = findViewById(R.id.textView);
        progressBar.setVisibility(View.INVISIBLE);
    }

    public void fetchDetails(View view) {
        // First get the book name entered by the user
        progressBar.setVisibility(View.VISIBLE);
        String a = editText.getText().toString();
        if(a.equalsIgnoreCase("")){
            editText.setError("Edit Text cannot be empty");
        }else{
            getData(a);
        }
    }

    private void getData(String a) {
        String url = "https://www.googleapis.com/books/v1/volumes?q="+a;
        // Do the volley Request
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.INVISIBLE);
                Gson gson = new Gson();
                Source source = gson.fromJson(response,Source.class);
                textView.setText("");
                for(Item i:source.getItems()){
                    textView.append(i.getVolumeInfo().getTitle()+"\n");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, "Error Has occured!", Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(request);
    }
}