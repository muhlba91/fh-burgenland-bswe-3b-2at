package io.muehlbachler.fhburgenland.swm.examination.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.muehlbachler.fhburgenland.swm.examination.model.Person;

/**
 * Repository for managing Person entities.
 */
public interface PersonRepository extends CrudRepository<Person, String> {

    /**
     * Queries for Persons based on their first name.
     *
     * @param firstName The first name query used to filter Persons.
     * @return List of Persons matching the provided first name query.
     */
    List<Person> findByFirstName(String firstName);


    /**
     * Queries for Persons based on their last name.
     *
     * @param lastName The last name query used to filter Persons.
     * @return List of Persons matching the provided last name query.
     */
    List<Person> findByLastName(String lastName);

}
