package io.muehlbachler.fhburgenland.swm.examination.service;

import java.util.List;
import java.util.Optional;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;

public interface NoteService {

    /**
     * Retrieves a Note by its unique identifier.
     *
     * @param id The unique identifier of the Note.
     * @return Optional containing the retrieved Note or empty if not found.
     */
    Optional<Note> get(String id);

    /**
     * Creates a new Note.
     *
     * @param note The Note object to be created.
     * @return The created Note entity.
     */
    Note create(Note note);

    /**
     * Queries for Notes based on content.
     *
     * @param query The content query used to filter Notes.
     * @return List of Notes matching the provided content query.
     */
    List<Note> queryByContent(String query);
}
