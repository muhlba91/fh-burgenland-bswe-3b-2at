package io.muehlbachler.fhburgenland.swm.examination.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.muehlbachler.fhburgenland.swm.examination.model.Person;

/**
 * Repository interface for performing CRUD operations on Person entities.
 */

public interface PersonRepository extends CrudRepository<Person, String> {

    /**
     * Retrieves a list of persons by their first name.
     *
     * @param firstName The first name of the persons to retrieve.
     * @return List of persons with the specified first name.
     */

    List<Person> findByFirstName(String firstName);

    /**
     * Retrieves a list of persons by their last name.
     *
     * @param lastName The last name of the persons to retrieve.
     * @return List of persons with the specified last name.
     */
    List<Person> findByLastName(String lastName);

    /**
     * Retrieves a list of persons by their first and last names.
     *
     * @param firstName The first name of the persons to retrieve.
     * @param lastName  The last name of the persons to retrieve.
     * @return List of persons with the specified first and last names.
     */
    List<Person> findByFirstNameAndLastName(String firstName, String lastName);
}
