package board.square;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testGetCurrentPosition() {
        Square square = new Square("98");
        assertTrue(square.getCurrentPosition().equals("98"));
    }

    @Test
    public void testDisplayCurrentPosition() {
        Square square = new Square("1");
        assertTrue(square.displayCurrentPosition().equals("001"));
    }

    @Test
    public void testGetSquareType() {
        Square square = new Square("1", SquareType.SNAKE);
        assertTrue(square.getSquareType().equals(SquareType.SNAKE));

        Square square2 = new Square("2", SquareType.LADDER);
        assertTrue(square2.getSquareType().equals(SquareType.LADDER));

        Square square3 = new Square("3");
        assertTrue(square3.getSquareType().equals(SquareType.VOID));
    }


}