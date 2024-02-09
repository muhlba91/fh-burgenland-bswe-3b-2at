package io.muehlbachler.fhburgenland.swm.examination.service;

import java.util.List;
import java.util.Optional;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.model.Person;

/**
 * Service interface for managing Person entities.
 */

public interface PersonService {

    /**
     * Retrieves a list of all Person entities.
     *
     * @return List of all Person entities.
     */

    public List<Person> getAll();

    /**
     * Retrieves a Person entity by its ID.
     *
     * @param id The ID of the Person to retrieve.
     * @return Optional containing the retrieved Person if found, or empty if not found.
     */
    public Optional<Person> get(String id);

    /**
     * Creates a new Person entity.
     *
     * @param person The Person object to be created.
     * @return The created Person entity.
     */
    public Person create(Person person);

    /**
     * Queries Person entities based on the provided first and last names.
     *
     * @param firstName The first name for querying.
     * @param lastName  The last name for querying.
     * @return List of Person entities matching the query.
     */
    // if any name (first or last) is empty, we only search for the other one
    public List<Person> findByName(String firstName, String lastName);

    /**
     * Creates a new Note associated with a specific Person.
     *
     * @param personId The ID of the Person for whom the note is created.
     * @param note     The Note object to be created.
     * @return Optional containing the created Note if successful, or empty if not.
     */
    public Optional<Note> createNote(String personId, Note note);
}
