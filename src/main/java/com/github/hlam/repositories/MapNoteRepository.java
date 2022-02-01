package com.github.hlam.repositories;

import com.github.hlam.domain.Note;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class MapNoteRepository implements NoteRepository {

    private final Map<Long, Note> repository;
    private final AtomicLong idSequence;

    public MapNoteRepository() {
        repository = new HashMap<>();
        idSequence = new AtomicLong(1L);
    }

    @Override
    public List<Note> findAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Optional<Note> findById(Long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public Note save(Note note) {
        if (note.getId() == null) {
            long id = idSequence.getAndIncrement();
            note.setId(id);
            repository.put(id, note);
        } else {
            repository.put(note.getId(), note);
        }
        return note;
    }

    @Override
    public void delete(Long id) {
        repository.remove(id);
    }
}
