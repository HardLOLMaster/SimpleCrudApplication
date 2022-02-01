package com.github.hlam.web.rest;

import com.github.hlam.domain.Note;
import com.github.hlam.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/note")
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @GetMapping("/note/{id}")
    public Note getById(@PathVariable Long id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isEmpty()) {
            return null;
        }
        return optionalNote.get();
    }

    @PostMapping("/note")
    public Note create(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @PutMapping("/note")
    public Note update(@RequestBody Note note) {
        if (note.getId() == null)
            throw new IllegalArgumentException("Id not specified");
        return noteRepository.save(note);
    }

    @DeleteMapping("/note/{id}")
    public void delete(@PathVariable Long id) {
        noteRepository.delete(id);
    }
}
