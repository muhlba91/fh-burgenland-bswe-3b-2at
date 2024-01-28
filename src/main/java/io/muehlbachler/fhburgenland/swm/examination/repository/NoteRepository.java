package io.muehlbachler.fhburgenland.swm.examination.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;

public interface NoteRepository extends CrudRepository<Note, String> {
    List<Note> findByContentContaining(String content);
}
