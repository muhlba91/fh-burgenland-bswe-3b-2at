package io.muehlbachler.fhburgenland.swm.examination.NoteService;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.repository.NoteRepository;
import io.muehlbachler.fhburgenland.swm.examination.service.impl.NoteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

/**
 * Tests for the NoteService class.
 */
@ExtendWith(MockitoExtension.class)
public class NoteServiceTests {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteServiceImpl noteService;

    /**
     * Tests the get method to ensure it retrieves a note by ID successfully.
     */
    @Test
    public void testGet() {
        String noteId = "1";
        Note note = new Note(noteId, "Some content");

        Mockito.when(noteRepository.findById(noteId)).thenReturn(Optional.of(note));

        Optional<Note> result = noteService.get(noteId);

        assertTrue(result.isPresent());
        assertEquals(note, result.get());
    }

    /**
     * Tests the create method to ensure it creates a new note successfully.
     */
    @Test
    public void testCreate() {
        Note note = new Note("1", "Some content");

        Mockito.when(noteRepository.save(any(Note.class))).thenReturn(note);

        Note result = noteService.create(note);

        assertEquals(note, result);
    }

    /**
     * Tests the querybycontent method to ensure it searches for notes by content.
     */
    @Test
    public void testQueryByContent() {
        String query = "Some";
        List<Note> notes = new ArrayList<>();
        notes.add(new Note("1", "Some content"));

        Mockito.when(noteRepository.findByContentContaining(query)).thenReturn(notes);

        List<Note> result = noteService.queryByContent(query);

        assertEquals(notes, result);
    }
}
