package com.kalkulator.lukasz.androidsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.kalkulator.lukasz.androidsqlite.db.NoteDAO;
import com.kalkulator.lukasz.androidsqlite.pojo.Note;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    //Button button;
    ListView listViev;
    private NoteDAO noteDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        //button = (Button)findViewById(R.id.button);
        listViev = (ListView)findViewById(R.id.listView);

        noteDAO = new NoteDAO(this);
    }



    // dodaje nową notatkę do bazy danych i odświeża listę
    public void addNewNote(View view) {
        Note note = new Note();
        String text = editText.getText().toString();
        if (text.length() > 0) {
            note.setNoteText(text);
        }

        noteDAO.insertNote(note);
        reloadNotesList();
    }

    // czyści db
    public void clearDB(View view) {
        noteDAO.deleteAll();
        reloadNotesList();
    }


    // usuwa notatkę z bazy i odświeża listę
    public void removeNote(Note note) {
        noteDAO.deleteNoteById(note.getId());
        reloadNotesList();
    }

    // pokazuje listę notatek
    private void reloadNotesList() {
        // pobieramy z bazy danych listę notatek
        List<Note> allNotes = noteDAO.getAllNotes();

        // ustawiamy adapter listy
        listViev.setAdapter(new ArrayAdapter<Note>(this, R.layout.note_layout, allNotes) {
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                final View noteView = super.getView(position, convertView, parent);

                // po kliknięciu na notatkę zostanie ona usunięta
                noteView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        removeNote(getItem(position));
                    }
                });

                return noteView;
            }
        });
    }





}
