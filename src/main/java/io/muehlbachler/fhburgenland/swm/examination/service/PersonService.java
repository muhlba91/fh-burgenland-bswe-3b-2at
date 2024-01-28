package io.muehlbachler.fhburgenland.swm.examination.service;

import java.util.List;
import java.util.Optional;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.model.Person;

public interface PersonService {
    public List<Person> getAll();

    public Optional<Person> get(String id);

    public Person create(Person person);

    // if any name (first or last) is empty, we only search for the other one
    public List<Person> findByName(String firstName, String lastName);

    public Optional<Note> createNote(String personId, Note note);
}
