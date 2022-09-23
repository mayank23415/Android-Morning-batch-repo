package in.nareshit.permissions;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.EntityIterator;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    boolean isAvailable = false, isWritable = false, isReadable = false;
    EditText name,age;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name_et);
        age = findViewById(R.id.age_et);
        result = findViewById(R.id.textView);
        
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            isAvailable = isReadable = isWritable = true;
        }else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            isAvailable = true; isWritable = false; isReadable = true;
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
            checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                // you can write logic for Accessing external storage
                Toast.makeText(this, "Permissions are granted", Toast.LENGTH_SHORT).show();
            }else {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 123);
            }
        }
    }

    public void loadData(View view) {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder,"Extern_example.txt");
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            StringBuilder sb = new StringBuilder();
            while((line = br.readLine())!=null){
                sb.append(line+"\n");
            }
            result.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveData(View view) {
        String n = name.getText().toString();
        int a = Integer.parseInt(age.getText().toString());
        // CREATE A FILE IN THE FOLDER THAT YOU WANT TO
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder,"Extern_example.txt");

        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            fos.write((n+"\n"+a).getBytes());
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        // WRITE CONTENT TO IT

        Toast.makeText(this, "SAVED", Toast.LENGTH_SHORT).show();
    }
}