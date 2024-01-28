package io.muehlbachler.fhburgenland.swm.examination.service;

import java.util.List;
import java.util.Optional;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;

public interface NoteService {
    Optional<Note> get(String id);

    Note create(Note note);

    List<Note> queryByContent(String query);
}
