package io.muehlbachler.fhburgenland.swm.examination.service;

import java.util.List;
import java.util.Optional;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;

/**
 * Service interface for managing Note entities.
 */

public interface NoteService {

    /**
     * Retrieves a Note entity by its ID.
     *
     * @param id The ID of the Note to retrieve.
     * @return Optional containing the retrieved Note if found, or empty if not found.
     */
    Optional<Note> get(String id);

    /**
     * Creates a new Note entity.
     *
     * @param note The Note object to be created.
     * @return The created Note entity.
     */
    Note create(Note note);

    /**
     * Queries Note entities based on the provided content.
     *
     * @param query The content to be used for querying Notes.
     * @return List of Note entities matching the query.
     */
    List<Note> queryByContent(String query);
}
