package io.muehlbachler.fhburgenland.swm.examination.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.service.NoteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class NoteControllerTests {
    @Mock
    private NoteService noteService;

    @InjectMocks
    private NoteController noteController;

    @Test
    void testGetById() {
        String noteId = "1";
        Note note = new Note(noteId, "Some content");

        when(noteService.get(noteId)).thenReturn(Optional.of(note));

        ResponseEntity<Note> noteResponse = noteController.get(noteId);

        assertEquals(HttpStatus.OK, noteResponse.getStatusCode(), "Note should be found");
        assertNotNull(noteResponse.getBody(), "Note should not be null");
        assertEquals("Some content", noteResponse.getBody().getContent(), "Note content should be 'Some content'");
    }


    @Test
    void testQueryByContent() {
        String query = "Some";
        List<Note> notes = new ArrayList<>();
        notes.add(new Note("1", "Some content"));

        when(noteService.queryByContent(query)).thenReturn(notes);

        List<Note> result = noteController.query(query);

        assertEquals(notes, result);
    }

    @Test
    void testQueryByContent2() {
        String query = "NonExistent";
        List<Note> emptyNotes = Collections.emptyList();

        when(noteService.queryByContent(query)).thenReturn(emptyNotes);

        List<Note> result = noteController.query(query);

        assertEquals(emptyNotes, result, "Query result should be an empty list");
    }

}
