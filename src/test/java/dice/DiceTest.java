package dice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    public void testRoll() {
        Dice dice = new Dice();
        Integer rollValue = dice.roll();
        assertTrue(1 <= rollValue && rollValue <= 6);
    }

}