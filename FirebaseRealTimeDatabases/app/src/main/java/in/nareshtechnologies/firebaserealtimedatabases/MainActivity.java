package in.nareshtechnologies.firebaserealtimedatabases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText n,a;
    TextView r;

    DatabaseReference dbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n = findViewById(R.id.person_name);
        a = findViewById(R.id.person_age);
        r = findViewById(R.id.result);

        dbr = FirebaseDatabase.getInstance().getReference("Person_Details");
    }

    public void saveData(View view) {
        String name = n.getText().toString();
        int age = Integer.parseInt(a.getText().toString());
        Person p = new Person(name,age);
        dbr.push().setValue(p);
        Toast.makeText(this, "Data is inserted!", Toast.LENGTH_SHORT).show();
    }


    public void loadData(View view) {
        r.setText("");
        dbr.orderByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren()){
                    Log.i("MAINKEY",ds.getKey());
                    Person p = ds.getValue(Person.class);
                    r.append(p.getName()+"\n"+p.getAge()+"\n\n");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}