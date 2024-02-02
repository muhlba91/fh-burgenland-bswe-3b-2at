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
     * retrieves a note by its unique id
     * @param id the unique id of the note
     * @return response entity with the note, or empty if the note doesnt exist
     */
    @Override
    public Optional<Note> get(String id) {
        return noteRepository.findById(id);
    }

    /**
     * creates a new note
     * @param note the note to create
     * @return the created note
     */
    @Override
    public Note create(Note note) {
        return noteRepository.save(note);
    }

    /**
     * retrieves all notes based on a specific content query
     * @param query the query to search for
     * @return list of notes that match the query
     */
    @Override
    public List<Note> queryByContent(String query) {
        return noteRepository.findByContentContaining(query);
    }
}
