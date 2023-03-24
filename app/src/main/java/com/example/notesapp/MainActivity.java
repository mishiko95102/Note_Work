package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.notesapp.adapter.NoteAdapter;
import com.example.notesapp.dialogue.NoteDialog;
import com.example.notesapp.model.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerNotesList;
    private FloatingActionButton addListButton;

    private NoteAdapter noteAdapter = new NoteAdapter();

    private List<Note> noteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListeners();
    }

    private void init() {
        recyclerNotesList = findViewById(R.id.list);
        addListButton = findViewById(R.id.add_button);
        recyclerNotesList.setAdapter(noteAdapter);
    }

    private void setListeners() {
        addListButton.setOnClickListener(view -> {
            NoteDialog noteDialog = new NoteDialog(this);
            noteDialog.show();
            noteDialog.setClickListener(note -> {
                addNote(note);
            });
        });
    }

    public void addNote(Note note) {
        noteList.add(note);
        noteAdapter.updateNotes(noteList);
    }
}