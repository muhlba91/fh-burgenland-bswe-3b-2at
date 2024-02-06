package io.muehlbachler.fhburgenland.swm.examination.service;

import java.util.List;
import java.util.Optional;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.model.Person;

/**
 * Service for managing Person entities.
 */
public interface PersonService {

    /**
     * Retrieves all Persons.
     *
     * @return List of all Persons.
     */
    List<Person> getAll();


    /**
     * Retrieves a Person by its unique identifier.
     *
     * @param id The unique identifier of the Person.
     * @return Optional containing the retrieved Person or empty if not found.
     */
    Optional<Person> get(String id);


    /**
     * Creates a new Person.
     *
     * @param person The Person object to be created.
     * @return The created Person entity.
     */
    Person create(Person person);


    /**
     * Queries for Persons based on first and last name.
     * if any name (first or last) is empty, we only search for the other one
     *
     * @param firstName The first name used for filtering.
     * @param lastName  The last name used for filtering.
     * @return List of Persons matching the provided first and last name.
     */
    List<Person> findByName(String firstName, String lastName);

    /**
     * Creates a new Note for a specified Person.
     *
     * @param personId The unique identifier of the Person.
     * @param note The Note object to be associated with the Person.
     * @return The created Note entity.
     */
    Optional<Note> createNote(String personId, Note note);
}
