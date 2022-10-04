package in.nareshtechnologies.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText stu_name, stu_age; TextView result;
    StudentsDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        // initialize the database object here
        database = Room.databaseBuilder(this,StudentsDatabase.class,"sample_database")
                .allowMainThreadQueries()
                .build();
    }

    public void saveData(View view) {
        String name = stu_name.getText().toString();
        int age = Integer.parseInt(stu_age.getText().toString());

        Students students = new Students();
        students.setStudent_name(name);
        students.setStudent_age(age);

        database.studentsDAO().insertStudent(students);
        Toast.makeText(this, "Inserted Successfully!", Toast.LENGTH_SHORT).show();
    }

    public void loadData(View view) {
        List<Students> students = database.studentsDAO().getStudents();
        result.setText("");
        for(Students s: students){
            result.append(s.getStudent_id()+"\n"+s.getStudent_name()+"\n"+s.getStudent_age()+"\n\n");
        }
    }

    private void initViews() {
        stu_age = findViewById(R.id.editTextTextPersonName2);
        stu_name = findViewById(R.id.stu_name);
        result = findViewById(R.id.textView);
    }
}