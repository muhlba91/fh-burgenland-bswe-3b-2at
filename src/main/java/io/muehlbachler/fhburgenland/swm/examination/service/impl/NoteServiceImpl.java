package io.muehlbachler.fhburgenland.swm.examination.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.repository.NoteRepository;
import io.muehlbachler.fhburgenland.swm.examination.service.NoteService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Service for managing Note entities.
 */
@NoArgsConstructor
@AllArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {


    @Autowired
    private NoteRepository noteRepository;

    /**
     * Retrieves a Note by its unique identifier.
     *
     * @param id The unique identifier of the Note.
     * @return Optional containing the retrieved Note or empty if not found.
     */
    @Override
    public Optional<Note> get(String id) {
        return noteRepository.findById(id);
    }

    /**
     * Creates a new Note.
     *
     * @param note The Note object to be created.
     * @return The created Note entity.
     */
    @Override
    public Note create(Note note) {
        return noteRepository.save(note);
    }

    /**
     * Queries for Notes based on content.
     *
     * @param query The content query used to filter Notes.
     * @return List of Notes matching the provided content query.
     */
    @Override
    public List<Note> queryByContent(String query) {
        return noteRepository.findByContentContaining(query);
    }
}
