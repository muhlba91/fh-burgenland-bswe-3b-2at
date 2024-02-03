package io.muehlbachler.fhburgenland.swm.examination.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.muehlbachler.fhburgenland.swm.examination.model.Person;



@SpringBootTest
public class PersonControllerTest {
    @Autowired
    private PersonController personController;

    @Test
    void testGetById() {
        ResponseEntity<Person> person = personController.get("81150016-8501-4b97-9168-01113e21d8a5");

        assertEquals(HttpStatus.OK, person.getStatusCode(), "person should be found");
        assertEquals("John", person.getBody().getFirstName(), "firstName should be John");
    }

    @Test
    void testCreateNote() {
        String personId = "81150016-8501-4b97-9168-01113e21d8a5";
        Note newNote = new Note("Some note");

        ResponseEntity<Note> createdNoteResponse = personController.createNote(personId, newNote);

        assertEquals(HttpStatus.OK, createdNoteResponse.getStatusCode(), "Note should be created successfully");
        assertNotNull(createdNoteResponse.getBody(), "Created note should not be null");
        assertEquals("Some note", createdNoteResponse.getBody().getContent(), "Note content should be 'Some note'");
    }

    @Test
    void testCreatePerson() {
        Person newPerson = new Person("John", "Doe");
        Person createdPerson = personController.create(newPerson);

        assertNotNull(createdPerson, "Person should be created successfully");
        assertEquals("John", createdPerson.getFirstName(), "First name should be John");
    }

}
