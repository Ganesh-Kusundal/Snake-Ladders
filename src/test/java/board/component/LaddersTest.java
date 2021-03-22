package board.component;

import exception.InvalidInputException;
import org.junit.jupiter.api.Test;
import util.ColorConstants;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LaddersTest {
    @Test
    void testSetLaddersForInvalidInput() {
        ILadders ladders = new Ladders();

        Map<Integer, Integer> laddersMap = new HashMap<>();
        laddersMap.put(6, 1);

        assertThrows(InvalidInputException.class, () -> ladders.setLadders(laddersMap), "User input is invalid, Start(Key) < End(Value)");
    }

    @Test
    void testNextPosition() throws InvalidInputException {
        ILadders ladders = new Ladders();

        Map<Integer, Integer> laddersMap = new HashMap<>();
        laddersMap.put(1, 6);
        ladders.setLadders(laddersMap);

        assertEquals(6, ladders.nextPosition(1));
    }
}