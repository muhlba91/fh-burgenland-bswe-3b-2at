package io.muehlbachler.fhburgenland.swm.examination.PersonServiceTest;
import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.model.Person;
import io.muehlbachler.fhburgenland.swm.examination.repository.NoteRepository;
import io.muehlbachler.fhburgenland.swm.examination.repository.PersonRepository;
import io.muehlbachler.fhburgenland.swm.examination.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)

public class PersonServiceTests {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    public void testGetAll() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("1", "Max", "Mustermann"));

        Mockito.when(personRepository.findAll()).thenReturn(persons);

        List<Person> result = personService.getAll();

        assertEquals(persons, result);
    }

    @Test
    public void testGet() {
        String personId = "1";
        Person person = new Person(personId, "Max", "Mustermann");

        Mockito.when(personRepository.findById(personId)).thenReturn(Optional.of(person));

        Optional<Person> result = personService.get(personId);

        assertTrue(result.isPresent());
        assertEquals(person, result.get());
    }

    @Test
    public void testCreate() {
        Person person = new Person("1", "John", "Doe");

        Mockito.when(personRepository.save(any(Person.class))).thenReturn(person);

        Person result = personService.create(person);

        assertEquals(person, result);
    }

//    @Test
//    public void testFindByName() {
//        String firstName = "John";
//        String lastName = "Doe";
//
//        List<Person> persons = new ArrayList<>();
//        persons.add(new Person("1", "John", "Doe"));
//
//        Mockito.when(personRepository.findByFirstNameAndLastName(firstName, lastName)).thenReturn(persons);
//
//        List<Person> result = personService.findByName(firstName, lastName);
//
//        assertEquals(persons, result);
//    }
//
//    @Test
//    public void testCreateNote() {
//        String personId = "1";
//        Person person = new Person(personId, "John", "Doe");
//        Note note = new Note("1", "Some note");
//
//        Mockito.when(personRepository.findById(personId)).thenReturn(Optional.of(person));
//        Mockito.when(noteRepository.save(any(Note.class))).thenReturn(note);
//
//        Optional<Note> result = personService.createNote(personId, note);
//
//        assertTrue(result.isPresent());
//        assertEquals(note, result.get());
//    }
}
