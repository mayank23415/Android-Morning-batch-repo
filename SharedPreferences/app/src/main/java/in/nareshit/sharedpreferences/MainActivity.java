package in.nareshit.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    EditText name,age;
    TextView result;
    //SharedPreferences object
    SharedPreferences preferences;

    // register the listener
    @Override
    protected void onResume() {
        super.onResume();
        preferences.registerOnSharedPreferenceChangeListener(this);
    }

    // unregister the listener
    @Override
    protected void onPause() {
        super.onPause();
        preferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name_et);
        age = findViewById(R.id.age_et);
        result = findViewById(R.id.textView);

        preferences = getSharedPreferences("NareshTechSP",MODE_PRIVATE);
    }

    public void saveData(View view) {
        String n = name.getText().toString();
        int a = Integer.parseInt(age.getText().toString());

        // By writing this line, you are allowing the sharepreferences to be edited
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NAME",n);
        editor.putInt("AGE",a);
        // This is not going to take any effect on shared preferences file. you need to
        // commit the changes - commit(), apply() on top of the editor object.
        editor.apply();
        Toast.makeText(this, "Data saved!", Toast.LENGTH_SHORT).show();
    }

    public void loadData(View view) {
        String n = preferences.getString("NAME","NO DATA FOUND");
        int a = preferences.getInt("AGE",0);
        result.setText(n+"\n"+a);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        String n = preferences.getString("NAME","NO DATA FOUND");
        int a = preferences.getInt("AGE",0);
        result.setText(n+"\n"+a);
    }
}