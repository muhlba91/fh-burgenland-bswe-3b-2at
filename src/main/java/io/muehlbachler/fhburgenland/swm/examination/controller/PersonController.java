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
import io.muehlbachler.fhburgenland.swm.examination.service.PersonService;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    private PersonService personService;


    /**
     * retrieves all persons
     * @return list of all persons
     */
    @GetMapping("/")
    public List<Person> list() {
        return personService.getAll();
    }

    /**
     * retrieves a person by its unique id
     * @param id the unique id of the person
     * @return response entity with the person, or empty if the person doesnt exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<Person> get(@PathVariable String id) {
        return ResponseEntity.of(personService.get(id));
    }

    /**
     * creates a new person
     * @param person the person to create
     * @return the created person
     */
    @PostMapping("/")
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    /**
     * retrieves all persons based on a specific name query
     * @param firstName the first name to search for
     * @param lastName the last name to search for
     * @return list of persons that match the query
     */
    @GetMapping("/query")
    public List<Person> query(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return personService.findByName(firstName, lastName);
    }

    /**
     * creates a new note for a person
     * @param id the unique id of the person
     * @param note the note to create
     * @return the created note
     */
    @PostMapping("/{id}/note")
    public ResponseEntity<Note> createNote(@PathVariable String id, @RequestBody Note note) {
        return ResponseEntity.of(personService.createNote(id, note));
    }
}
