package in.nareshit.checkboxes_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private CheckBox eng,hin,tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.country);
        eng = findViewById(R.id.eng);
        hin = findViewById(R.id.hindi);
        tel = findViewById(R.id.tel);

        // TODO 1: Prepare the data first
        String[] states = new String[]{"Andhra Pradesh","Telangana","West Bengal","Maharastra","Bihar"};

        //TODO 2: We need to create an Adapter as we want to populate multiple data on a single view
        // For Spinner, we use ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                states);

        // TODO 3: set the Adapter to Spinner
        spinner.setAdapter(adapter);
    }


    public void submitForm(View view) {
        String languages = "";
        if(eng.isChecked()){
            languages = languages+"English"+"\n";
        }

        if(hin.isChecked()){
            languages = languages+"Hindi"+"\n";
        }

        if(tel.isChecked()){
            languages = languages+"Telugu"+"\n";
        }

        Toast.makeText(this, languages, Toast.LENGTH_SHORT).show();
    }
}