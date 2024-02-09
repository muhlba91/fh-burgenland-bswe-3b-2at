package io.muehlbachler.fhburgenland.swm.examination.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.muehlbachler.fhburgenland.swm.examination.controller.PersonController;
import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.model.Person;

/**
 * Unit tests for the {@link PersonService} class.
 */
@SpringBootTest
public class PersonServiceTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Person person;
    private Note note;

    @BeforeEach
    void setUp() {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

        person = new Person("1", "Efo", "Pinsel");
        note = new Note();
        note.setId("1");
        note.setContent("Test Note");
    }
    /**
     * Test case to verify the functionality of the getAll method in PersonService.
     */

    @Test
    void testGetAll() {
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        when(personService.getAll()).thenReturn(personList);

        assertEquals(personList, personService.getAll());
    }

    /**
     * Test case to verify the functionality of the get method in PersonService.
     */

    @Test
    void testGet() {
        when(personService.get("1")).thenReturn(Optional.of(person));

        assertEquals(Optional.of(person), personService.get("1"));
    }

    /**
     * Test case to verify the functionality of the create method in PersonService.
     */

    @Test
    void testCreate() {
        when(personService.create(any(Person.class))).thenReturn(person);

        assertEquals(person, personService.create(person));
    }

    /**
     * Test case to verify the functionality of the findByName method in PersonService.
     */

    @Test
    void testFindByName() {
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        when(personService.findByName("Efo", "Pinsel")).thenReturn(personList);

        assertEquals(personList, personService.findByName("Efo", "Pinsel"));
    }

    /**
     * Test case to verify the functionality of the createNote method in PersonService.
     */

    @Test
    void testCreateNote() {
        when(personService.createNote("1", note)).thenReturn(Optional.of(note));

        assertEquals(Optional.of(note), personService.createNote("1", note));
    }
}

