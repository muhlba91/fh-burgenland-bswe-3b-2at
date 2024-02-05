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

@NoArgsConstructor
@AllArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    /**
     * Retrieves a Note entity by its ID.
     *
     * @param id The ID of the Note to retrieve.
     * @return Optional containing the retrieved Note if found, or empty if not found.
     */

    @Override
    public Optional<Note> get(String id) {
        return noteRepository.findById(id);
    }

    /**
     * Creates a new Note entity.
     *
     * @param note The Note object to be created.
     * @return The created Note entity.
     */

    @Override
    public Note create(Note note) {
        return noteRepository.save(note);
    }

    /**
     * Queries Note entities based on the provided content.
     *
     * @param query The content to be used for querying Notes.
     * @return List of Note entities matching the query.
     */

    @Override
    public List<Note> queryByContent(String query) {
        return noteRepository.findByContentContaining(query);
    }
}
