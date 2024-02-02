package io.muehlbachler.fhburgenland.swm.examination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.model.Person;
import io.muehlbachler.fhburgenland.swm.examination.service.NoteService;
import io.muehlbachler.fhburgenland.swm.examination.service.PersonService;

@RestController
@RequestMapping("note")
public class NoteController {


    @Autowired
    private NoteService noteService;

    /**
     *  retrieves a note by its unique id
     * @param id the unique id of the note
     * @return  response entity with the note, or empty if the note doesnt exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> get(@PathVariable String id) {
        return ResponseEntity.of(noteService.get(id));
    }

    /**
     *
     *  retrieves all notes based on a specific content query
     * @param query the query to search for
     * @return  list of notes that match the query
     */
    @GetMapping("/query")
    public List<Note> query(@RequestParam("query") String query) {
        return noteService.queryByContent(query);
    }
}
