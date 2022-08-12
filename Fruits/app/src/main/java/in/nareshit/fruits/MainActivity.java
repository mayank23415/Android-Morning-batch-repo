package in.nareshit.fruits;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView custom_list;

    private String names[];
    private int images[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        custom_list = findViewById(R.id.custom_list);
        names = new String[]{"Apple","Banana","Guava","Grapes"};
        images = new int[]{R.drawable.apple,R.drawable.banana,R.drawable.guava, R.drawable.grapes};
        CustomAdapter ca = new CustomAdapter();
        custom_list.setAdapter(ca);
    }

    public class CustomAdapter extends BaseAdapter{

        // This returns the number of items we would like to display
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view == null){
                // We can intialize it
                view = getLayoutInflater().inflate(R.layout.one_item_design,viewGroup,false);
            }
            TextView t = view.findViewById(R.id.fruit_name);
            ImageView im = view.findViewById(R.id.fruit_image);
            im.setImageResource(images[i]);
            t.setText(names[i]);
            return view;
        }
    }
}