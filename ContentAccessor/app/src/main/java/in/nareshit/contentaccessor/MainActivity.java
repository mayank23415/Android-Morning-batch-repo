package in.nareshit.contentaccessor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String authorities = "content://in.nareshtechnologies.morningbatch.CONTENT";
    TextView tv;
    public static final String COL_1 = "student_name";
    public static final String COL_2 = "student_age";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.data_here);

        // AS soon as this app loads, we want to bring data from the other app
        // TODO 1: Create a URI with the authorities
        Uri CONTENT_URI = Uri.parse(authorities);
        Cursor c = getContentResolver().query(CONTENT_URI,null,null,null,null);
        tv.setText("");
        if(c!=null){
            c.moveToFirst();
            do{
                int s_id = c.getInt(0);
                String s_name = c.getString(1);
                int age = c.getInt(2);
                tv.append(s_id+"\n"+s_name+"\n"+age+"\n\n");
            }while(c.moveToNext());
        }

        ContentValues values = new ContentValues();
        values.put(COL_1,"Aniruddh");
        values.put(COL_2,20);
        Uri uri = getContentResolver().insert(CONTENT_URI,values);
        if(uri!=null){
            Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
        }
    }
}