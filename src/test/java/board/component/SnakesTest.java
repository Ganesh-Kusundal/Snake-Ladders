package board.component;

import exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SnakesTest {
    @Test
    void testSetSnakesForInvalidInput() {
        ISnakes snakes = new Snakes();

        Map<Integer, Integer> snakesMap = new HashMap<>();
        snakesMap.put(1, 6);

        assertThrows(InvalidInputException.class, () -> snakes.setSnakes(snakesMap), "User input is invalid, Start(Key) > End(Value)");
    }

    @Test
    void testNextPosition() throws InvalidInputException {
        ISnakes snakes = new Snakes();

        Map<Integer, Integer> laddersMap = new HashMap<>();
        laddersMap.put(6, 1);
        snakes.setSnakes(laddersMap);

        assertEquals(1, snakes.nextPosition(6));
    }
}