package board;

import board.square.Square;
import player.Player;

import java.util.Map;

public interface IBoard {
    Integer NUMBER_OF_ROWS = 10;
    Integer NUMBER_OF_COLS = 10;
    Integer INITIAL_POSITION = 1;
    Integer FINAL_POSITION = 100;

    Square gameBoard[][] = new Square[NUMBER_OF_ROWS][NUMBER_OF_COLS];

    Square[][] getBoard();

    Map<Player, Integer> getPlayerPositions();

    boolean movePlayer(Player player);

}
