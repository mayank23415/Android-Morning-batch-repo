package in.nareshit.internalmemory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText name,age;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name_et);
        age = findViewById(R.id.age_et);
        result = findViewById(R.id.textView);
    }

    public void saveData(View view) {
        String n = name.getText().toString();
        int a = Integer.parseInt(age.getText().toString());
        // Inorder to create a file or to write to a file we need FileOutputStream object
        FileOutputStream fos;
        try {
            fos = openFileOutput("DEMO.txt",MODE_PRIVATE);
            fos.write((n+"\n").getBytes());
            fos.write((""+a).getBytes());
            // Once you are done with the writing conent to the file, always always do call close() on top of fos
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_SHORT).show();
    }

    public void loadData(View view) {
        FileInputStream fis;
        try {
            fis = openFileInput("DEMO.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            StringBuilder stringBuilder = new StringBuilder();
            while((line = br.readLine())!=null){
                stringBuilder.append(line+"\n");
            }
            result.setText(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}