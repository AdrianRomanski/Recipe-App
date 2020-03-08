package adrianromanski.converters;

import adrianromanski.commands.UnitOfMeasureCommand;
import adrianromanski.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    private static final String DESCRIPTION = "description";
    private static final String LONG_VALUE = "1L";

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() {
        // Given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        // When
        UnitOfMeasure uoc = converter.convert(command);

        // Then
        assertNotNull(uoc);
        assertEquals(LONG_VALUE, uoc.getId());
        assertEquals(DESCRIPTION, uoc.getDescription());
    }
}