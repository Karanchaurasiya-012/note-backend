package com.notesapp.service;

import com.notesapp.model.Note;
import java.util.List;

public interface NoteService {
    Note createNote(Note note);
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note updateNote(Long id, Note updatedNote);
    void deleteNote(Long id);
    Note getNoteByShareId(String shareId);
}
