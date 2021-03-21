package player;

import org.junit.jupiter.api.Test;
import util.ColorConstants;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void testTakeTurn() {
        Player player = new Player("P1", ColorConstants.ANSI_GREEN_BACKGROUND);
        Integer roll = player.takeTurn();
        assertTrue(1 <= roll && roll <= 6);
    }

    @Test
    public void testGetColor() {
        Player player = new Player("P1", ColorConstants.ANSI_YELLOW_BACKGROUND);
        assertTrue(player.getPlayerColor().equalsIgnoreCase(ColorConstants.ANSI_YELLOW_BACKGROUND));
    }

    @Test
    public void testGetName() {
        Player player = new Player("P1", ColorConstants.ANSI_YELLOW_BACKGROUND);
        assertTrue(player.getName().equalsIgnoreCase("P1"));
    }
}