package io.muehlbachler.fhburgenland.swm.examination.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;

/**
 * Repository for managing Note entities.
 */
public interface NoteRepository extends CrudRepository<Note, String> {

    /**
     * Queries for Notes based on content.
     *
     * @param content The content query used to filter Notes.
     * @return List of Notes matching the provided content query.
     */
    List<Note> findByContentContaining(String content);
}
