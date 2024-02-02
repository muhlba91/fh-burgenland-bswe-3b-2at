package io.muehlbachler.fhburgenland.swm.examination.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;

public interface NoteRepository extends CrudRepository<Note, String> {

    /**
     * retrieves all notes based on a specific content query
     * @param content the content to search for
     * @return list of notes that match the query
     */
    List<Note> findByContentContaining(String content);
}
