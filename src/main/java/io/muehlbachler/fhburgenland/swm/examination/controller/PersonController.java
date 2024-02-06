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

/**
 * Controller for managing Person entities.
 */
@RestController
@RequestMapping("person")
public class PersonController {

    /**
     * Service for managing Person entities.
     */
    @Autowired
    private PersonService personService;

    /**
     * Retrieves a list of all persons.
     *
     * @return List of all Person entities.
     */
    @GetMapping("/")
    public List<Person> list() {
        return personService.getAll();
    }

    /**
     * Retrieves a Person by its unique identifier.
     *
     * @param id The unique identifier of the Person.
     * @return ResponseEntity containing the retrieved Person or empty if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Person> get(@PathVariable String id) {
        return ResponseEntity.of(personService.get(id));
    }

    /**
     * Creates a new Person.
     *
     * @param person The Person object to be created.
     * @return The created Person entity.
     */
    @PostMapping("/")
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    /**
     * Queries for Persons based on first and last name.
     *
     * @param firstName The first name used for filtering.
     * @param lastName  The last name used for filtering.
     * @return List of Persons matching the provided first and last names.
     */
    @GetMapping("/query")
    public List<Person> query(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        return personService.findByName(firstName, lastName);
    }

    /**
     * Creates a new Note for a specified Person.
     *
     * @param id   The unique identifier of the Person.
     * @param note The Note object to be associated with the Person.
     * @return ResponseEntity containing the created Note or empty if the Person is not found.
     */
    @PostMapping("/{id}/note")
    public ResponseEntity<Note> createNote(@PathVariable String id, @RequestBody Note note) {
        return ResponseEntity.of(personService.createNote(id, note));
    }
}
