package database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import model.Person;

@Dao
public interface PersonDAO {
    @Query("Select * from person order by id")
    LiveData<List<Person>> getPersonList();

    @Insert
    void insertPerson(Person person);

    @Update
    void updatePerson(Person person);

    @Delete
    void deletePerson(Person person);

    @Query("select * from person where id = :id")
    Person getPersonById(int id);
}
