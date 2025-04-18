package org.hasanceliktr.note.service;

import org.hasanceliktr.note.model.Note;
import org.hasanceliktr.note.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note updateNote(Long id, Note updatedNote) {
        Note note = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Not bulunamadı."));
        note.setTitle(updatedNote.getTitle());
        note.setContent(updatedNote.getContent());
        return noteRepository.save(note);
    }
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

}
