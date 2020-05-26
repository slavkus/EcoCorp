package database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import model.Person;

@Database(entities = Person.class, exportSchema = false, version = 1)
public abstract class PersonDatabase extends RoomDatabase {
    private static final String LOG_TAG = PersonDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DB_NAME = "persondb";
    private static PersonDatabase instance;

    public static synchronized PersonDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        PersonDatabase.class, DB_NAME)
                        .build();
            }
        }
        return instance;
    }

    public abstract PersonDAO personDAO();
}
