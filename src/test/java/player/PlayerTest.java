package player;

import org.junit.jupiter.api.Test;
import util.ColorConstants;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {

    @Test
    void testTakeTurn() {
        Player player = new Player("P1", ColorConstants.ANSI_GREEN_BACKGROUND);
        Integer roll = player.takeTurn();
        assertTrue(1 <= roll && roll <= 6);
    }

    @Test
    void testGetColor() {
        Player player = new Player("P1", ColorConstants.ANSI_YELLOW_BACKGROUND);
        assertTrue(player.getPlayerColor().equalsIgnoreCase(ColorConstants.ANSI_YELLOW_BACKGROUND));
    }

    @Test
    void testGetName() {
        Player player = new Player("P1", ColorConstants.ANSI_YELLOW_BACKGROUND);
        assertTrue(player.getName().equalsIgnoreCase("P1"));
    }

    @Test
    void testSetDice_with_CroockedDice() {
        Player player = new Player("P1", ColorConstants.ANSI_YELLOW_BACKGROUND);
        Player.setDice(2);
        Integer roll = player.takeTurn();
        assertTrue(2 == roll || 4 == roll || 6 == roll);

    }

    @Test
    void testSetDice_with_NormalDice() {
        Player player = new Player("P1", ColorConstants.ANSI_YELLOW_BACKGROUND);
        Player.setDice(1);
        Integer roll = player.takeTurn();
        assertTrue(1 <= roll && roll <= 6);
    }
}