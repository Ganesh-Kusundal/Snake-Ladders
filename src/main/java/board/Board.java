package board;

import board.square.Square;
import player.Player;
import util.ColorConstants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Board {

    private static final Integer NUMBER_OF_ROWS = 10;
    private static final Integer NUMBER_OF_COLS = 10;
    private static final int INITIAL_POSITION = 1;
    private static final int FINAL_POSITION = 100;

    private Square[][] gameBoard;
    private Map<Player, Integer> playerPositions;


    public Board(List<Player> players) {
        initializePlayers(players);
        initializeGameBoard();
    }

    private void initializeGameBoard() {
        gameBoard = new Square[NUMBER_OF_ROWS][NUMBER_OF_COLS];

        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            for (int col = 0; col < NUMBER_OF_COLS; col++) {
                gameBoard[row][col]
                        = new Square(String.valueOf(calculateVertexValue(row, col)));
            }
        }
    }

    private Integer calculateVertexValue(int row, int col) {
        if (row % 2 == 0)
            return (NUMBER_OF_COLS * NUMBER_OF_ROWS) - (row * 10) - col;
        return (NUMBER_OF_COLS * NUMBER_OF_ROWS) - (row * 10) + col - 9;
    }

    private void initializePlayers(List<Player> players) {
        this.playerPositions = new HashMap<>();
        players.forEach(player -> this.playerPositions.put(player, INITIAL_POSITION));
    }

    public boolean movePlayer(Player player) {
        int position = playerPositions.get(player) + player.takeTurn();

        if (position <= FINAL_POSITION)
            playerPositions.put(player, position);

        if (FINAL_POSITION == position) {
            System.out.println("Player " + player.getPlayerColor() + player.getName() + ColorConstants.ANSI_RESET + " Is Winner...Hurray!!!\n");
            return true;
        }
        return false;
    }

    public String getBoard() {
        StringBuilder board = new StringBuilder();

        Arrays.stream(gameBoard).forEach(list -> {
            Arrays.stream(list).forEach(e -> board.append(getVertexValue(e)));
            board.append("\n");
        });

        return board.toString();
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
        return playerPositions.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue)).get(Integer.parseInt(e.getCurrentPosition()));
    }
}
