package io.muehlbachler.fhburgenland.swm.examination.service;

import java.util.List;
import java.util.Optional;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;

public interface NoteService {

    /**
     * retrieves a note by its unique id
     * @param id the unique id of the note
     * @return response entity with the note, or empty if the note doesnt exist
     */
    Optional<Note> get(String id);

    /**
     * creates a new note
     * @param note the note to create
     * @return the created note
     */
    Note create(Note note);

    /**
     * retrieves all notes based on a specific content query
     * @param query the query to search for
     * @return list of notes that match the query
     */
    List<Note> queryByContent(String query);
}
