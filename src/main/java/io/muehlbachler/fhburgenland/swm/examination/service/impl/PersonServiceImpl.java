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
     * Retrieves a list of all Person entities.
     *
     * @return List of all Person entities.
     */
    public List<Person> getAll() {
        return Lists.newArrayList(personRepository.findAll());
    }

    /**
     * Retrieves a Person entity by its ID.
     *
     * @param id The ID of the Person to retrieve.
     * @return Optional containing the retrieved Person if found, or empty if not found.
     */

    public Optional<Person> get(String id) {
        return personRepository.findById(id);
    }

    /**
     * Creates a new Person entity.
     *
     * @param person The Person object to be created.
     * @return The created Person entity.
     */

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    /**
     * Queries Person entities based on the provided first and last names.
     *
     * @param firstName The first name for querying.
     * @param lastName  The last name for querying.
     * @return List of Person entities matching the query.
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
     * Creates a new Note associated with a specific Person.
     *
     * @param personId The ID of the Person for whom the note is created.
     * @param note     The Note object to be created.
     * @return Optional containing the created Note if successful, or empty if not.
     */
    @Override
    public Optional<Note> createNote(String personId, Note note) {
        return get(personId).map((Person person) -> {
            note.setPerson(person);
            return noteService.create(note);
        });
    }
}
