package board.component;

import exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakesTest {
    @Test
    void testSetSnakesForInvalidInput() {
        assertThrows(InvalidInputException.class, () -> new Snake(1, 6), "User input is invalid, it must be mouth value > tail value.");
    }

    @Test
    void testNextPosition() throws InvalidInputException {
        ISnake snakes = new Snake(6, 1);
        assertEquals(1, snakes.nextPosition(6));
    }

    @Test
    void testIsSnake() throws InvalidInputException {
        ISnake snakes = new Snake(6, 1);
        assertTrue(snakes.isSnake(6));
    }
}