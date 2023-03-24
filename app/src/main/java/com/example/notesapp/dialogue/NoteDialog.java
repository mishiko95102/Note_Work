package com.example.notesapp.dialogue;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;

import com.example.notesapp.R;
import com.example.notesapp.model.Note;
import com.google.android.material.button.MaterialButton;

public class NoteDialog extends Dialog {

    private SaveClickListener saveClickListener;

    private EditText titleEditText;
    private EditText descriptionEditText;

    private MaterialButton cancelButton;
    private MaterialButton saveButton;

    public NoteDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_note);

        init();

        setListeners();
    }

    private void init() {
        titleEditText = findViewById(R.id.title_edit_text);
        descriptionEditText = findViewById(R.id.description_edit_text);

        cancelButton = findViewById(R.id.cancel_button);
        saveButton = findViewById(R.id.save_button);
    }

    private void setListeners() {
        cancelButton.setOnClickListener(view -> {
            dismiss();
        });

        saveButton.setOnClickListener(view -> {
            String text = titleEditText.getText().toString();
            String description = descriptionEditText.getText().toString();

            if (saveClickListener != null)
                saveClickListener.onClick(new Note(text, description));

            dismiss();
        });
    }

    public interface SaveClickListener {
        void onClick(Note note);
    }

    public void setClickListener(SaveClickListener saveClickListener) {
        this.saveClickListener = saveClickListener;
    }
}
