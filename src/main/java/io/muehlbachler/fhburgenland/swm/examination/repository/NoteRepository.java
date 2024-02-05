package io.muehlbachler.fhburgenland.swm.examination.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;

/**
 * Repository interface for performing CRUD operations on Note entities.
 */
public interface NoteRepository extends CrudRepository<Note, String> {

    /**
     * Retrieves a list of notes containing the specified content.
     *
     * @param content The content to search for within notes.
     * @return List of notes containing the specified content.
     */

    List<Note> findByContentContaining(String content);
}
