package io.muehlbachler.fhburgenland.swm.examination.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import io.muehlbachler.fhburgenland.swm.examination.model.Note;


@SpringBootTest
@AutoConfigureMockMvc
class NoteServiceTest {

    @MockBean
    private NoteService noteService;

    private Note note;

    @BeforeEach
    void setUp() {
        note = new Note();
        note.id = "1";
        note.setContent("Test Note");
    }

    /**
     * Test case to verify the successful retrieval of a note by ID in the NoteService.
     */

    @Test
    void testGetNoteByIdSuccess() {
        when(noteService.get("1")).thenReturn(Optional.of(note));
        Optional<Note> retrievedNote = noteService.get("1");
        assertTrue(retrievedNote.isPresent());
        assertEquals("Test Note", retrievedNote.get().getContent());
    }

    /**
     * Test case to verify the scenario when a note is not found by ID in the NoteService.
     */

    @Test
    void testGetNoteByIdNotFound() {
        when(noteService.get("2")).thenReturn(Optional.empty());
        Optional<Note> retrievedNote = noteService.get("2");
        assertFalse(retrievedNote.isPresent());
    }

    /**
     * Test case to verify the creation of a note in the NoteService.
     */

    @Test
    void testCreateNote() {
        when(noteService.create(any(Note.class))).thenReturn(note);
        Note createdNote = noteService.create(note);
        assertEquals("1", createdNote.id);
        assertEquals("Test Note", createdNote.getContent());
    }

    /**
     * Test case to verify the querying of notes by content in the NoteService.
     */

    @Test
    void testQueryNotesByContent() {
        List<Note> notes = new ArrayList<>();
        notes.add(note);
        when(noteService.queryByContent("Test")).thenReturn(notes);
        List<Note> queriedNotes = noteService.queryByContent("Test");
        assertEquals(1, queriedNotes.size());
        assertEquals("Test Note", queriedNotes.get(0).getContent());
    }
}

