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

    public List<Person> getAll() {
        return Lists.newArrayList(personRepository.findAll());
    }

    public Optional<Person> get(String id) {
        return personRepository.findById(id);
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> findByName(String firstName, String lastName) {
        if (firstName.isEmpty() && !lastName.isEmpty()) {
            return personRepository.findByFirstName(lastName);
        } else if (lastName.isEmpty() && !firstName.isEmpty()) {
            return personRepository.findByLastName(firstName);
        }
        return Lists.newArrayList();
    }

    @Override
    public Optional<Note> createNote(String personId, Note note) {
        return get(personId).map((Person person) -> {
            note.setPerson(person);
            return noteService.create(note);
        });
    }
}
