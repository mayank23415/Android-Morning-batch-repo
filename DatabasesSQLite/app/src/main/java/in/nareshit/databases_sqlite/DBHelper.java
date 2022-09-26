package in.nareshit.databases_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    // CREATE SOME IMPORTANT CONSTANTS
    public static final String DATABASE_NAME = "School";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "students";
    public static final String COL_0 = "student_id";
    public static final String COL_1 = "student_name";
    public static final String COL_2 = "student_age";

    String CREATE_COMMAND = "create table "+TABLE_NAME+"("+COL_0+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            ""+COL_1+" TEXT, "+COL_2+" INTEGER);";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // This method is responsible to create the Database tables in the database "School"
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_COMMAND);
    }

    // This method is useful to upgrade the version of DB
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertData(ContentValues values){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(TABLE_NAME,null,values);
    }
}
