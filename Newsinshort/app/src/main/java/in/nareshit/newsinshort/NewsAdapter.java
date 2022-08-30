package in.nareshit.newsinshort;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewholder>{

    Context context;
    List<News> newsArticles;

    public NewsAdapter(Context context, List<News> newsArticles) {
        this.context = context;
        this.newsArticles = newsArticles;
    }

    @NonNull
    @Override
    public NewsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsViewholder(LayoutInflater.from(context).inflate(R.layout.one_item_design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewholder holder, int position) {
        // TODO : Display an image
        // TODO: Display the title of the news.
        Glide.with(context).load(newsArticles.get(position).getImageUrl()).into(holder.news_image);
        holder.title.setText(newsArticles.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return newsArticles.size();
    }

    public class NewsViewholder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView news_image;
        public NewsViewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_news);
            news_image = itemView.findViewById(R.id.image_news);
        }
    }
}
