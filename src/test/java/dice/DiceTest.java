package dice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceTest {

    @Test
    void testRoll() {
        Dice dice = new Dice();
        Integer rollValue = dice.roll();
        assertTrue(1 <= rollValue && rollValue <= 6);
    }

}