package io.muehlbachler.fhburgenland.swm.examination.controller;

import io.muehlbachler.fhburgenland.swm.examination.model.Note;
import io.muehlbachler.fhburgenland.swm.examination.service.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class NoteControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteService noteService;

    private Note note;

    @BeforeEach
    void setUp() {
        note = new Note();
        note.id = "1"; // Directly setting the id field
        note.setContent("Test Note");
    }
    /**
     * Test case to verify the successful retrieval of a note by ID.
     *
     * @throws Exception if an error occurs during the test execution
     */

    @Test
    void testGetNoteByIdSuccess() throws Exception {
        when(noteService.get("1")).thenReturn(Optional.of(note));
        mockMvc.perform(MockMvcRequestBuilders.get("/note/{id}", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("Test Note"));
    }
    /**
     * Test case to verify the handling of a not found note by ID.
     *
     * @throws Exception if an error occurs during the test execution
     */

    @Test
    void testGetNoteByIdNotFound() throws Exception {
        when(noteService.get("2")).thenReturn(Optional.empty());
        mockMvc.perform(MockMvcRequestBuilders.get("/note/{id}", "2"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Test case to verify the querying of notes by content.
     *
     * @throws Exception if an error occurs during the test execution
     */
    @Test
    void testQueryNotesByContent() throws Exception {
        List<Note> notes = new ArrayList<>();
        notes.add(note);
        when(noteService.queryByContent("Test")).thenReturn(notes);
        mockMvc.perform(MockMvcRequestBuilders.get("/note/query")
                        .param("query", "Test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content").value("Test Note"));
    }


}
