package io.muehlbachler.fhburgenland.swm.examination.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.model.Person;
import io.muehlbachler.fhburgenland.swm.examination.repository.PersonRepository;
import io.muehlbachler.fhburgenland.swm.examination.service.NoteService;
import io.muehlbachler.fhburgenland.swm.examination.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private NoteService noteService;

    /**
     * Retrieves a list of all persons.
     *
     * @return List of all Person entities.
     */
    public List<Person> getAll() {
        return Lists.newArrayList(personRepository.findAll());
    }

    /**
     * Retrieves a Person by its unique identifier.
     *
     * @param id The unique identifier of the Person.
     * @return Optional containing the retrieved Person or empty if not found.
     */
    public Optional<Person> get(String id) {
        return personRepository.findById(id);
    }

    /**
     * Creates a new Person.
     *
     * @param person The Person object to be created.
     * @return The created Person entity.
     */
    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }


    /**
     * Queries for Persons based on first and last name.
     *
     * @param firstName The first name used for filtering.
     * @param lastName  The last name used for filtering.
     * @return List of Persons matching the provided first and last names.
     */
    @Override
    public List<Person> findByName(String firstName, String lastName) {
        if (firstName.isEmpty() && !lastName.isEmpty()) {
            return personRepository.findByFirstName(lastName);
        } else if (lastName.isEmpty() && !firstName.isEmpty()) {
            return personRepository.findByLastName(firstName);
        }
        return Lists.newArrayList();
    }

    /**
     * Creates a new Note for a specified Person.
     *
     * @param personId The unique identifier of the Person.
     * @param note     The Note object to be associated with the Person.
     * @return Optional containing the created Note or empty if the Person is not found.
     */
    @Override
    public Optional<Note> createNote(String personId, Note note) {
        return get(personId).map((Person person) -> {
            note.setPerson(person);
            return noteService.create(note);
        });
    }
}
