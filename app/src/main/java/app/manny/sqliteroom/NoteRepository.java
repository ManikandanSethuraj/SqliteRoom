package app.manny.sqliteroom;


import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.TimeUnit;

import app.manny.sqliteroom.model.Note;
import app.manny.sqliteroom.persistance.NoteDatabase;

public class NoteRepository {


    private NoteDatabase noteDatabase;

    public NoteRepository(Context context){
        noteDatabase = NoteDatabase.getInstance(context);
    }

    public void insertData(Note note){
        AppExecuters.getInstance().getExecutors().schedule(() -> {noteDatabase.getDao().insertallData(note);},0, TimeUnit.MICROSECONDS);

    }

    public LiveData<List<Note>> getAllData(){

        return noteDatabase.getDao().getAllCustomData();
    }

    public void deleteData(Note note){
        AppExecuters.getInstance().getExecutors().schedule(() -> {noteDatabase.getDao().deleteData(note);},0, TimeUnit.MICROSECONDS);
      //  noteDatabase.getDao().deleteData(note);
    }

    public void updateData(Note note){
        AppExecuters.getInstance().getExecutors().schedule(() -> {noteDatabase.getDao().updateData(note);},0, TimeUnit.MICROSECONDS);

     //   noteDatabase.getDao().updateData(note);
    }

}
