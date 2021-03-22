package board;

import board.square.Square;
import exception.InvalidInputException;
import player.Player;
import util.ColorConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BaseBoard implements IBoard {
    protected Map<Player, Integer> playerPositions;

    public BaseBoard(List<Player> players) {
        initializePlayers(players);
        initializeGameBoard();
    }


    private void initializeGameBoard() {
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

        if (nextPosition <= FINAL_POSITION)
            playerPositions.put(player, nextPosition);

        if (FINAL_POSITION == nextPosition) {
            System.out.println("Player " + player.getPlayerColor() + player.getName() + ColorConstants.ANSI_RESET + " Is Winner...Hurray!!!\n");
            return true;
        }
        return false;
    }


    public Square[][] getBoard() {
        return gameBoard;
    }

    @Override
    public Map<Player, Integer> getPlayerPositions() {
        return playerPositions;
    }


}
