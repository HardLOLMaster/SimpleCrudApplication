package com.github.hlam.repositories;

import com.github.hlam.domain.Note;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {
    List<Note> findAll();

    Optional<Note> findById(Long id);

    Note save(Note note);

    void delete(Long id);
}
