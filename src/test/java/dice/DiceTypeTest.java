package dice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiceTypeTest {

    @Test
    void testGetDiceTypeFromRank() {
        assertEquals(DiceType.CROOCKED_DICE, DiceType.CROOCKED_DICE.getDiceTypeFromRank(2));
        assertEquals(DiceType.NORMAL_DICE, DiceType.CROOCKED_DICE.getDiceTypeFromRank(1));

    }
}