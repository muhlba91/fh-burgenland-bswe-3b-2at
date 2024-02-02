package io.muehlbachler.fhburgenland.swm.examination.service;

import java.util.List;
import java.util.Optional;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.model.Person;

public interface PersonService {

    /**
     * retrieves all persons
     * @return list of all persons
     */
    public List<Person> getAll();

    /**
     * retrieves a person by its unique id
     * @param id the unique id of the person
     * @return response entity with the person, or empty if the person doesnt exist
     */
    public Optional<Person> get(String id);

    /**
     * creates a new person
     * @param person the person to create
     * @return the created person
     */
    public Person create(Person person);

    /**
     * retrieves all persons based on a specific name query
     * if any name (first or last) is empty, we only search for the other one
     * @param firstName the first name to search for
     * @param lastName the last name to search for
     * @return list of persons that match the query
     */
    public List<Person> findByName(String firstName, String lastName);

    /**
     * creates a new note for a person
     * @param personId the unique id of the person
     * @param note the note to create
     * @return the created note
     */
    public Optional<Note> createNote(String personId, Note note);
}
