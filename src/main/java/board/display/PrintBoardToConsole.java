package board.display;

import board.IBoard;
import board.square.Square;
import player.Player;
import util.ColorConstants;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintBoardToConsole implements IPrintBoard {

    private IBoard board;

    public PrintBoardToConsole(IBoard board) {
        this.board = board;
    }

    @Override
    public void printBoard() {
        Square[][] squares = board.getBoard();

        StringBuilder display = new StringBuilder();
        Arrays.stream(squares).forEach(list -> {
            Arrays.stream(list).forEach(e -> display.append(getVertexValue(e)));
            display.append("\n");
        });

        System.out.println(display.toString());
    }

    private String getVertexValue(Square e) {
        return getPlayerForVertexPosition(e) != null ?
                " " + e.displayCurrentPosition() + "[" + getPlayersList(e) + ColorConstants.ANSI_RESET + "]" :
                " " + e.displayCurrentPosition() + "[  ]";
    }

    private String getPlayersList(Square e) {
        return getPlayerForVertexPosition(e).stream()
                .map(p -> p.getKey().getPlayerColor() + p.getKey().getName()).sorted().collect(Collectors.joining(","));
    }

    private List<Map.Entry<Player, Integer>> getPlayerForVertexPosition(Square e) {
        return board.getPlayerPositions().entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue)).get(Integer.parseInt(e.getCurrentPosition()));
    }
}
