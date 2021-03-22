package board.display;

import board.Board;
import board.component.ILadder;
import board.component.ISnake;
import board.component.Ladder;
import board.component.Snake;
import exception.InvalidInputException;
import org.junit.jupiter.api.Test;
import player.Player;
import util.ColorConstants;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PrintBoardToConsoleTest {
    @Test
    void testPrintBoard() throws InvalidInputException {
        ILadder ladder = new Ladder(5, 10);
        List<ILadder> ladders = Arrays.asList(ladder);

        ISnake snake = new Snake(14, 7);
        List<ISnake> snakes = Arrays.asList(snake);

        Player player1 = new Player("P1", ColorConstants.ANSI_RED_BACKGROUND);
        Player player2 = new Player("P2", ColorConstants.ANSI_GREEN_BACKGROUND);

        Board board = new Board(Arrays.asList(player1, player2), snakes, ladders);

        board.movePlayer(player1);

        board.movePlayer(player2);



        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        IPrintBoard print = new PrintBoardToConsole(board);
        print.printBoard();

        // Our baos has the content from the print statement
        String output = new String(baos.toByteArray());

        assertTrue(output.contains("[" + ColorConstants.ANSI_RED_BACKGROUND + "P1" + ColorConstants.ANSI_RESET + "]"));
        assertTrue(output.contains("[" + ColorConstants.ANSI_GREEN_BACKGROUND + "P2" + ColorConstants.ANSI_RESET + "]"));

    }

}