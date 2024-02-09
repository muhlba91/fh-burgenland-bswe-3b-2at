package io.muehlbachler.fhburgenland.swm.examination.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.muehlbachler.fhburgenland.swm.examination.model.Person;
import io.muehlbachler.fhburgenland.swm.examination.service.PersonService;

/**
 * Unit tests for the {@link PersonController} class.
 */

@SpringBootTest
public class PersonControllerTest {

    @Autowired
    private PersonController personController;

    @Autowired
    private PersonService personService;

    @Test
    void testGetById() {
        ResponseEntity<Person> person =
                personController.get("81150016-8501-4b97-9168-01113e21d8a5");

        assertEquals(HttpStatus.OK, person.getStatusCode(), "Person should be found");
        assertEquals("John", person.getBody().getFirstName(), "First name should be John");
    }
    /**
     * Test case to verify the listing of persons.
     */

    @Test
    void testList() {
        // Mock data
        List<Person> persons = Arrays.asList(
                new Person("1", "John", "Doe"),
                new Person("2", "Ofe", "Pinsel")
        );
        PersonService personService = mock(PersonService.class);
        when(personService.getAll()).thenReturn(persons);

        // Test the list endpoint
        PersonController personController = new PersonController();
        personController.personService = personService; // Directly inject the PersonService
        List<Person> result = personController.list();

        assertNotNull(result, "Result should not be null");
        assertEquals(2, result.size(), "List should contain two persons");
    }
    /**
     * Test case to verify the creation of a person.
     */

    @Test
    void testCreate() {
        // Mock data
        Person personToCreate = new Person("3", "Ahmed", "Kebab");
        PersonService personService = mock(PersonService.class);
        when(personService.create(any(Person.class))).thenReturn(personToCreate);

        // Test the create endpoint
        PersonController personController = new PersonController();
        personController.personService = personService; // Directly inject the PersonService
        Person createdPerson = personController.create(personToCreate);

        assertNotNull(createdPerson, "Created person should not be null");
        assertEquals("Ahmed", createdPerson.getFirstName(), "First name should be Ahmed");
    }
    /**
     * Test case to verify the querying of persons by name.
     */

    @Test
    void testQuery() {
        // Mock data
        List<Person> persons = Arrays.asList(
                new Person("1", "John", "Doe"),
                new Person("2", "Ofe", "Pinsel")
        );
        PersonService personService = mock(PersonService.class);
        when(personService.findByName("John", "Doe")).thenReturn(persons);

        // Test the query endpoint
        PersonController personController = new PersonController();
        personController.personService = personService;
        List<Person> result = personController.query("John", "Doe");

        assertNotNull(result, "Result should not be null");
        assertEquals(2, result.size(), "List should contain two persons");
        assertEquals("John", result.get(0).getFirstName(),
                "First name of first person should be John");
    }
}
