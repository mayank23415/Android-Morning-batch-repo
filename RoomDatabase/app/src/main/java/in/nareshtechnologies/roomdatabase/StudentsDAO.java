package in.nareshtechnologies.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentsDAO {

    @Insert
    void insertStudent(Students s);

    @Query("Select * from students")
    List<Students> getStudents();

    @Update
    void updateStudent(Students s);

}


/**
 * Room Database is designed based on ORM (Object Relational Mapping)
 * https://en.wikipedia.org/wiki/Object%E2%80%93relational_mapping
 * */