package app.manny.sqliteroom.persistance;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import app.manny.sqliteroom.model.Note;

// Data Accessing Objects (DAO)

/**
 * DAO is used between the rest of the app and Room Database to access objects.
 */

@Dao
public interface NoteDao {


    /**
     * Insert is used to add data to the Table
     * long[] denotes the number array of data inserted in the table
     * Note... denotes a list means Note... is equal to Note[]
     * @param notes
     * @return
     */
    @Insert
    long[] insertallData(Note... notes);


    /**
     * Get all data from the notes
     * @return
     */
    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getAllCustomData();


    /**
     * Get all data from the notes table matching the given ID
     * @param id
     * @return
     */
    @Query("SELECT * FROM notes WHERE id = :id")
    LiveData<List<Note>> getAllIDCustomData(int id);

    /**
     * Get all data from the notes table matching the given Title
     * @param title
     * @return
     */
    @Query("SELECT * FROM notes WHERE title LIKE :title")
    LiveData<List<Note>> getTitleCustomData(String title);


    /**
     * Get all data from the Notes
     * @param notes
     * @return
     */
    @Delete
    int deleteData(Note... notes);


    /**
     * Update the data in the notes table
     * @param notes
     * @return
     */
    @Update
    int updateData(Note... notes);
}
