package board.square;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetCurrentPosition() {
        Square square = new Square("98");
        assertEquals("98", square.getCurrentPosition());
    }

    @Test
    void testDisplayCurrentPosition() {
        Square square = new Square("1");
        assertEquals("001", square.displayCurrentPosition());
    }

    @Test
    void testGetSquareType() {
        Square square = new Square("1", SquareType.SNAKE);
        assertEquals(SquareType.SNAKE, square.getSquareType());

        Square square2 = new Square("2", SquareType.LADDER);
        assertEquals(SquareType.LADDER, square2.getSquareType());

        Square square3 = new Square("3");
        assertEquals(SquareType.VOID, square3.getSquareType());
    }

}