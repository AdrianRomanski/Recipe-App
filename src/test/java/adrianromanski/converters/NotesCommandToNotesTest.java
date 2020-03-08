package adrianromanski.converters;

import adrianromanski.commands.NotesCommand;
import adrianromanski.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesCommandToNotesTest {

    private static final String ID_VALUE = "1L";
    private static final String RECIPE_NOTES = "Notes";
    private NotesCommandToNotes converter;

    @Before
    public void setUp() {
        converter = new NotesCommandToNotes();
    }

    @Test
    public void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new NotesCommand()));
    }


    @Test
    public void convert() {
        // Given
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setRecipeNotes(RECIPE_NOTES);

        // When
        Notes notes = converter.convert(notesCommand);

        // Then
        assertNotNull(notes);
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
    }
}