package board;

import board.component.*;
import board.square.Square;
import exception.InvalidInputException;
import org.junit.jupiter.api.Test;
import player.Player;
import util.ColorConstants;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardTest {
    @Test
    void testGetBoard() throws InvalidInputException {
        Player player1 = new Player("P1", ColorConstants.ANSI_RED_BACKGROUND);
        Player player2 = new Player("P2", ColorConstants.ANSI_GREEN_BACKGROUND);
        List<Player> players = Arrays.asList(player1, player2);

        ISnake snake = new Snake(10, 2);
        ISnake snake2 = new Snake(20, 7);
        ISnake snake3 = new Snake(6, 1);
        ISnake greenSnake = new GreenSnake(50, 25);
        List<ISnake> snakes = Arrays.asList(snake, snake2, snake3, greenSnake);

        ILadder ladder = new Ladder(2, 25);
        List<ILadder> ladders = Arrays.asList(ladder);

        BaseBoard gameBaseBoard = new Board(players, snakes, ladders);
        Square[][] board = gameBaseBoard.getBoard();

        boolean done = false;
        while (!done) {
            done = gameBaseBoard.movePlayer(player1);
        }

        assertEquals("100", board[0][0].displayCurrentPosition());
        assertEquals("001", board[IBoard.NUMBER_OF_ROWS - 1][0].displayCurrentPosition());
    }

    @Test
    void testMovePlayer() throws InvalidInputException {
        Player player1 = new Player("P1", ColorConstants.ANSI_BLUE_BACKGROUND);
        List<Player> players = Arrays.asList(player1);

        ISnake snake = new Snake(10, 2);
        List<ISnake> snakes = Arrays.asList(snake);

        ILadder ladder = new Ladder(2, 25);
        List<ILadder> ladders = Arrays.asList(ladder);

        BaseBoard gameBaseBoard = new Board(players, snakes, ladders);

        boolean done = false;
        while (!done) {
            done = gameBaseBoard.movePlayer(player1);
        }
        assertTrue(done);
    }
}