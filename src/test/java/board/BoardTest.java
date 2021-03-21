package board;

import org.junit.jupiter.api.Test;
import player.Player;
import util.ColorConstants;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void testGetBoard() {
        Player player1 = new Player("P1", ColorConstants.ANSI_RED_BACKGROUND);
        Player player2 = new Player("P2", ColorConstants.ANSI_GREEN_BACKGROUND);

        Board gameBoard = new Board(Arrays.asList(player1, player2));
        gameBoard.movePlayer(player1);

        assertTrue(gameBoard.getBoard().contains(player1.getName()));
        assertTrue(gameBoard.getBoard().contains(player2.getName()));
    }

    @Test
    public void testMovePlayer() {
        Player player1 = new Player("P1", ColorConstants.ANSI_BLUE_BACKGROUND);

        Board gameBoard = new Board(Arrays.asList(player1));

        boolean done = false;
        while(!done) {
            done = gameBoard.movePlayer(player1);
        }

        assertTrue(done);
    }
}