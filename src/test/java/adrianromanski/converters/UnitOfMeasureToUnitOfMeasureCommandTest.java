package adrianromanski.converters;

import adrianromanski.commands.UnitOfMeasureCommand;
import adrianromanski.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    private static final String DESCRIPTION = "description";
    private static final String LONG_VALUE = "1L";

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() {
        // Given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(LONG_VALUE);
        uom.setDescription(DESCRIPTION);

        // When
        UnitOfMeasureCommand command = converter.convert(uom);

        // Then
        assertNotNull(command);
        assertEquals(LONG_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
    }
}