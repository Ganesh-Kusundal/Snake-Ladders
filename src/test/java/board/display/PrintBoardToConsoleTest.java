package board.display;

import board.Board;
import board.component.ILadders;
import board.component.ISnakes;
import board.component.Ladders;
import board.component.Snakes;
import org.junit.jupiter.api.Test;
import player.Player;
import util.ColorConstants;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PrintBoardToConsoleTest {
    @Test
    void testPrintBoard() {
        ILadders ladders = new Ladders();
        Map<Integer, Integer> laddersMap = new HashMap<>();
        laddersMap.put(5, 10);

        ISnakes snakes = new Snakes();
        Map<Integer, Integer> snakesMap = new HashMap<>();
        snakesMap.put(14, 7);

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