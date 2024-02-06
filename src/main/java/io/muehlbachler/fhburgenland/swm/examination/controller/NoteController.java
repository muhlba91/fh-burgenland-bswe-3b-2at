package io.muehlbachler.fhburgenland.swm.examination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.service.NoteService;

/**
 * Controller for managing Note entities.
 */
@RestController
@RequestMapping("note")
public class NoteController {


    /**
     * Service for managing Note entities.
     */
    @Autowired
    private NoteService noteService;

    /**
     * Retrieves a Note by its unique identifier.
     *
     * @param id The unique identifier of the Note.
     * @return ResponseEntity containing the retrieved Note or empty if not found.
     */

    @GetMapping("/{id}")
    public ResponseEntity<Note> get(@PathVariable String id) {
        return ResponseEntity.of(noteService.get(id));
    }

    /**
     * Queries for Notes based on a specific content query.
     *
     * @param query The content query used to filter Notes.
     * @return List of Notes matching the provided content query.
     */
    @GetMapping("/query")
    public List<Note> query(@RequestParam("query") String query) {
        return noteService.queryByContent(query);
    }
}
