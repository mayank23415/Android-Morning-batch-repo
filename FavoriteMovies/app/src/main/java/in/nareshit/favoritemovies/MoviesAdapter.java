package in.nareshit.favoritemovies;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>
{
    Context context;
    int[] posters;
    String mNames[],aNames[];

    public MoviesAdapter(Context context, int[] posters, String[] mNames, String[] aNames) {
        this.context = context;
        this.posters = posters;
        this.mNames = mNames;
        this.aNames = aNames;
    }

    // This method is going to attach the layout file (one_item_design.xml) to the View object
    // and sends this info to Viewholder.
    // When the adapter is set on the Recyclerview this method will add this layoutfile to the items of the Recyclerview
    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.one_item_design,parent,false);
        return new MoviesViewHolder(v);
    }

    // This method is responsible to populate the data based on the position of the item.
    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        holder.iv.setImageResource(posters[position]);
        holder.tv1.setText(mNames[position]);
        holder.tv2.setText(aNames[position]);
    }

    // This method returns the total number of items in the recyclerview.
    @Override
    public int getItemCount() {
        return posters.length;
    }

    // This will have the view info of the one_item_design.xml
    public class MoviesViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView tv1,tv2;
        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.imageView);
            tv1 = itemView.findViewById(R.id.textView_mv);
            tv2 = itemView.findViewById(R.id.textView_an);
        }
    }
}
