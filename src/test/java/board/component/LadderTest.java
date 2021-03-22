package board.component;

import exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    void testSetLaddersForInvalidInput() {
        assertThrows(InvalidInputException.class, () -> new Ladder(6, 1), "User input is invalid, it must be Start(Key) < End(Value).");
    }

    @Test
    void testNextPosition() throws InvalidInputException {
        ILadder ladders = new Ladder(1, 6);
        assertEquals(6, ladders.nextPosition(1));
    }

    @Test
    void testIsLadder() throws InvalidInputException {
        ILadder ladder = new Ladder(1, 6);
        assertTrue(ladder.isLadder(1));
    }
}