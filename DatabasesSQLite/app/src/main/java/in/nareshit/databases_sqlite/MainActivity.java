package in.nareshit.databases_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, age;
    TextView result;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name_et);
        age = findViewById(R.id.age_et);
        result = findViewById(R.id.textView);
        dbHelper = new DBHelper(this);
    }

    public void saveData(View view) {
        String n = name.getText().toString();
        int a = Integer.parseInt(age.getText().toString());
        // CONTENT VALUES
        ContentValues values = new ContentValues();
        values.put(DBHelper.COL_1,n);
        values.put(DBHelper.COL_2, a);
        dbHelper.insertData(values);
        Toast.makeText(this, "DATA IS SUCCESSFULLY INSERTED", Toast.LENGTH_SHORT).show();
    }

    public void loadData(View view) {

    }

    /*
    * Two Important Classes
    * SQLiteDatabase - Core class (methods like insert, update etc are created)
    * SQLiteOpenHelper - Helper class (we need this class to make the database transactions easy)
    * */
}