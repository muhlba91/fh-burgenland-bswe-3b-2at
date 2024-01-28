package io.muehlbachler.fhburgenland.swm.examination.service;

import java.util.List;
import java.util.Optional;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.model.Person;

public interface PersonService {
    public List<Person> getAll();

    public Optional<Person> get(String id);

    public Person create(Person person);

    public List<Person> findByName(String firstName, String lastName);

    public Optional<Note> createNote(String personId, Note note);
}
