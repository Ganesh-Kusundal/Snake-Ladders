package board;

import board.square.Square;
import exception.InvalidInputException;
import player.Player;
import util.ColorConstants;
import validator.InputValidator;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Board {

    private static final Integer NUMBER_OF_ROWS = 10;
    private static final Integer NUMBER_OF_COLS = 10;
    private static final int INITIAL_POSITION = 1;
    private static final int FINAL_POSITION = 100;

    private Square[][] gameBoard;
    private Map<Player, Integer> playerPositions;
    private Map<Integer, Integer> ladders;
    private Map<Integer, Integer> snakes;

    private InputValidator validator = new InputValidator();


    public Board(List<Player> players) {
        initializePlayers(players);
        initializeGameBoard();
    }

    public void setLadders(Map<Integer, Integer> ladders) throws InvalidInputException {
        validator.isValidInput(ladders, e -> e.getKey() < e.getValue());
        this.ladders = ladders;
    }

    public void setSnakes(Map<Integer, Integer> snakes) throws InvalidInputException {
        validator.isValidInput(snakes, e -> e.getKey() > e.getValue());
        this.snakes = snakes;
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
        Integer nextPosition = playerPositions.get(player) + player.takeTurn();

        if (isSnake(nextPosition))
            nextPosition = snakes.get(nextPosition);

        if (isLadder(nextPosition))
            nextPosition = ladders.get(nextPosition);

        if (nextPosition <= FINAL_POSITION)
            playerPositions.put(player, nextPosition);

        if (FINAL_POSITION == nextPosition) {
            System.out.println("Player " + player.getPlayerColor() + player.getName() + ColorConstants.ANSI_RESET + " Is Winner...Hurray!!!\n");
            return true;
        }
        return false;
    }

    private boolean isLadder(int position) {
        return ladders != null && ladders.get(position) != null;
    }

    private boolean isSnake(int position) {
        return snakes != null && snakes.get(position) != null;
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
