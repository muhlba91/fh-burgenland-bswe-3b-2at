package io.muehlbachler.fhburgenland.swm.examination.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.muehlbachler.fhburgenland.swm.examination.model.Person;

public interface PersonRepository extends CrudRepository<Person, String> {

    /**
     * retrieves all persons based on a specific first name
     * @param firstName the first name to search for
     * @return list of persons that match the query
     */
    List<Person> findByFirstName(String firstName);

    /**
     * retrieves all persons based on a specific last name
     * @param lastName the last name to search for
     * @return list of persons that match the query
     */
    List<Person> findByLastName(String lastName);

    /**
     * retrieves all persons based on a specific first and last name query
     * @param firstName the first name to search for
     * @param lastName the last name to search for
     * @return list of persons that match the query
     */
    List<Person> findByFirstNameAndLastName(String firstName, String lastName);
}
