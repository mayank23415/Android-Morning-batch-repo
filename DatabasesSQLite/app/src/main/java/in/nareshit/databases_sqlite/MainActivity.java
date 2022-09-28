package in.nareshit.databases_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
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

    // Read the data and fetch the results to the user
    public void loadData(View view) {
        Cursor c = dbHelper.readData();
        //Toast.makeText(this, ""+c.getColumnIndex(DBHelper.COL_2), Toast.LENGTH_SHORT).show();
        if(c!=null){
            c.moveToFirst();
            result.setText("");
            do{
                int stu_id = c.getInt(0);
                String s_n = c.getString(1);
                int s_a = c.getInt(2);
                result.append(stu_id+"\t"+s_n+"\t"+s_a+"\n\n");
            }while(c.moveToNext());
        }
    }

    
    public void updateData(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COL_1,"KUMAR");
        contentValues.put(DBHelper.COL_2,50);
        dbHelper.updateData(contentValues,1);
        Toast.makeText(this, "UPDATE is done", Toast.LENGTH_SHORT).show();
    }

    public void deleteData(View view) {
        dbHelper.deleteRow(1);
        Toast.makeText(this, "row is deleted", Toast.LENGTH_SHORT).show();
    }


    /*
    * Two Important Classes
    * SQLiteDatabase - Core class (methods like insert, update etc are created)
    * SQLiteOpenHelper - Helper class (we need this class to make the database transactions easy)
    * Creating a table
    * Inserting the values into the table
    * Drop
    * Read Data
    * Update Data
    * Delete
    * */
}