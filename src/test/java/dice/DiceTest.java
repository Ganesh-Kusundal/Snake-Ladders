package dice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceTest {

    @Test
    void testNormalDiceRoll() {
        Dice dice = new NormalDice();
        Integer rollValue = dice.roll();
        assertTrue(1 <= rollValue && rollValue <= 6);
    }

    @Test
    void testCrookedDiceRoll() {
        Dice dice = new CrookedDice();
        Integer rollValue = dice.roll();
        assertTrue(rollValue % 2 == 0);
    }

}