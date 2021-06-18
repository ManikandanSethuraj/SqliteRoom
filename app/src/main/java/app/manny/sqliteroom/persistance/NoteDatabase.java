package app.manny.sqliteroom.persistance;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import app.manny.sqliteroom.model.Note;


/**
 * Creating Database for Entity Note.
 * Version will be upgraded if any changes to Entity structure. (like Note class has 1 primary key and 3 Columns, if any other column is added the Version has to be incremented)
 * This Abstract class, so can't be instantiated.
 */
@Database(entities = Note.class,version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "notes_db";
    private static NoteDatabase instance;

    // Singleton pattern
    public static NoteDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class,DATABASE_NAME).build();
        }
        return instance;
    }

    public abstract NoteDao getDao();

}
