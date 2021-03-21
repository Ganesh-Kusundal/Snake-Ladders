package board;

import dice.Dice;
import exception.InvalidInputException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import player.Player;
import util.ColorConstants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        while (!done) {
            done = gameBoard.movePlayer(player1);
        }
        assertTrue(done);
    }

    @Test
    public void testSetLadders() throws InvalidInputException {
        Player player1 = Mockito.mock(Player.class);
        Board gameBoard = new Board(Arrays.asList(player1));

        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(2, 100);
        gameBoard.setLadders(ladders);

        Mockito.when(player1.takeTurn()).thenReturn(1);

        assertTrue(gameBoard.movePlayer(player1));
    }

    @Test
    public void testSetSnakes() throws InvalidInputException {
        Player player1 = Mockito.mock(Player.class);
        Board gameBoard = new Board(Arrays.asList(player1));

        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(6, 1);
        gameBoard.setSnakes(snakes);

        Mockito.when(player1.takeTurn()).thenReturn(5);
        Mockito.when(player1.getName()).thenReturn("Player1");
        Mockito.when(player1.getPlayerColor()).thenReturn(ColorConstants.ANSI_GREEN_BACKGROUND);

        assertTrue(gameBoard.getBoard().contains("001[" + ColorConstants.ANSI_GREEN_BACKGROUND + "Player1" + ColorConstants.ANSI_RESET +"]"));
    }

    @Test
    public void testSetSnakesForInvalidInput()  {
        Player player1 = Mockito.mock(Player.class);
        Board gameBoard = new Board(Arrays.asList(player1));

        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(1, 5);
        assertThrows(InvalidInputException.class, () -> gameBoard.setSnakes(snakes), "snake must have start value > end value");
    }

    @Test
    public void testSetLaddersForInvalidInput()  {
        Player player1 = Mockito.mock(Player.class);
        Board gameBoard = new Board(Arrays.asList(player1));

        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(5, 1);
        assertThrows(InvalidInputException.class, () -> gameBoard.setLadders(ladders), "ladder must have start value < end value");
    }

}