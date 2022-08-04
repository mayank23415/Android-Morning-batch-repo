package in.nareshit.uicomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText pName, pAge;
    private RadioGroup gGroup;
    private Spinner countrySpinner;
    private Switch fanSwitch;
    private Button submit;
    private TextView result;

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
                    result.setText("MALE");
                }else if(id == R.id.female){
                    result.setText("FEMALE");
                }else{
                    result.setText("Prefer Not to Say");
                }
            }
        });
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // When the spinner items are selected, we invoke this method
                String country = adapterView.getItemAtPosition(i).toString();
                result.setText(country);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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

    }
}