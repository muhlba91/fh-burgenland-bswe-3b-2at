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
     * Retrieves a list of all Person entities.
     *
     * @return List of all Person entities.
     */

    @GetMapping("/")
    public List<Person> list() {
        return personService.getAll();
    }

    /**
     * Retrieves a specific Person by ID.
     *
     * @param id The ID of the Person.
     * @return ResponseEntity containing the retrieved Person, or empty if not found.
     */

    @GetMapping("/{id}")
    public ResponseEntity<Person> get(@PathVariable String id) {
        return ResponseEntity.of(personService.get(id));
    }

    /**
     * Creates a new Person entity.
     *
     * @param person The Person object to be created.
     * @return The created Person entity.
     */

    @PostMapping("/")
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }


    /**
     * Queries Person entities based on first and last names.
     *
     * @param firstName The first name for querying.
     * @param lastName  The last name for querying.
     * @return List of Person entities matching the query.
     */
    @GetMapping("/query")
    public List<Person> query(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return personService.findByName(firstName, lastName);
    }

    /**
     * Creates a new Note for a specific Person.
     *
     * @param id   The ID of the Person.
     * @param note The Note object to be created.
     * @return ResponseEntity containing the created Note, or empty if not successful.
     */
    @PostMapping("/{id}/note")
    public ResponseEntity<Note> createNote(@PathVariable String id, @RequestBody Note note) {
        return ResponseEntity.of(personService.createNote(id, note));
    }
}
