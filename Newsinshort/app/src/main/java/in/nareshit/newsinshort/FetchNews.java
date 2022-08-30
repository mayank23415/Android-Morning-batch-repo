package in.nareshit.newsinshort;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class FetchNews extends AsyncTask<String,Void,String> {

    Context context;
    RecyclerView recyclerView;
    ProgressBar progressBar;

    public FetchNews(Context context, RecyclerView recyclerView, ProgressBar progressBar) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.progressBar = progressBar;
    }

    @Override
    protected String doInBackground(String... strings) {
        // This method runs on Worker thread, so what ever the long running operation
        // you have you can do it here.
        String link = strings[0];
        // Convert the url in string format to a proper url format
        try {
            URL url = new URL(link);
            // Establish a HttpsURLConnection - We get the connection from the url
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            // get the input stream from the connection.
            InputStream is = connection.getInputStream();
            // Simply extract the data out of the is
            BufferedReader br  = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line = "";
            while((line=br.readLine())!=null){
                sb.append(line);
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // This method runs on MainThread
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        List<News> list = new ArrayList<>();
        progressBar.setVisibility(View.GONE);
        try {
            JSONObject root_object = new JSONObject(s);
            JSONArray data = root_object.getJSONArray("data");
            for(int i=0; i<data.length(); i++){
                JSONObject news = data.getJSONObject(i);
                String title = news.getString("title");
                String content = news.getString("content");
                String imageUrl = news.getString("imageUrl");
                list.add(new News(title,content,imageUrl));
            }

            NewsAdapter newsAdapter = new NewsAdapter(context,list);
            recyclerView.setAdapter(newsAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/* AsyncTask<DataType-1, DataType-2, DataType-3>
Data Type -1 -> This is the input type of doInBackground(...)
Data Type -2 -> for OnProgressUpdate(...)
Data Type -3 -> This is the input type of onPostExecute(...)
 */