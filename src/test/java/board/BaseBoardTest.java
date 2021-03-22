package board;

import board.square.Square;
import org.junit.jupiter.api.Test;
import player.Player;
import util.ColorConstants;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseBoardTest {

    @Test
    void testGetBoard() {
        Player player1 = new Player("P1", ColorConstants.ANSI_RED_BACKGROUND);
        Player player2 = new Player("P2", ColorConstants.ANSI_GREEN_BACKGROUND);

        BaseBoard gameBaseBoard = new BaseBoard(Arrays.asList(player1, player2));
        Square[][] board = gameBaseBoard.getBoard();

        assertEquals("100", board[0][0].displayCurrentPosition());
        assertEquals("001", board[IBoard.NUMBER_OF_ROWS - 1][0].displayCurrentPosition());
    }

    @Test
    void testMovePlayer() {
        Player player1 = new Player("P1", ColorConstants.ANSI_BLUE_BACKGROUND);
        BaseBoard gameBaseBoard = new BaseBoard(Arrays.asList(player1));

        boolean done = false;
        while (!done) {
            done = gameBaseBoard.movePlayer(player1);
        }
        assertTrue(done);
    }

}