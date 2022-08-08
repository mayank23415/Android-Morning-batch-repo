package in.nareshit.uicomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText pName, pAge;
    private RadioGroup gGroup;
    private Spinner countrySpinner;
    private Switch fanSwitch;
    private Button submit;
    private TextView result;

    private String gender,nation,fan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // We initialize the views
        initViews();
        submit.setOnClickListener(this);
        // get data out of the radio group / radio buttons
        gGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                // get the RadioButton Id that is checked.
                int id = radioGroup.getCheckedRadioButtonId();
                if(id == R.id.male){
                    gender = "Male";
                }else if(id == R.id.female){
                    gender = "Female";
                }else{
                    gender = "Prefer Not To Say!";
                }
            }
        });
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // When the spinner items are selected, we invoke this method
                nation = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        fanSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    fan = "ON";
                }else{
                    fan = "OFF";
                }
            }
        });
    }

    private void initViews() {
        // findViewById(...) connects the views on xml file to the objects using the id of the view.
        pName = findViewById(R.id.person_name);
        pAge = findViewById(R.id.person_age);
        gGroup = findViewById(R.id.gender);
        countrySpinner = findViewById(R.id.spinner);
        fanSwitch = findViewById(R.id.switch_pref);
        submit = findViewById(R.id.submit);
        result = findViewById(R.id.result);
    }

    @Override
    public void onClick(View view) {
        // This is the place where your button logic goes in
        String n = pName.getText().toString();
        int a = Integer.parseInt(pAge.getText().toString());
        result.setText("");

        result.append(n+"\n");
        result.append(a+"\n");
        result.append(gender+"\n");
        result.append(nation+"\n");
        result.append(fan);
    }
}