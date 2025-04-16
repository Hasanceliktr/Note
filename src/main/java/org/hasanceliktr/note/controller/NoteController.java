package org.hasanceliktr.note.controller;

import org.hasanceliktr.note.model.Note;
import org.hasanceliktr.note.service.NoteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public Note createNote(Note note) {
        return noteService.createNote(note);
    }

    @PutMapping(("/{id}"))
    public Note updateNote(@PathVariable Long id, Note note) {
        return noteService.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }


}
