package game;

import board.Board;
import exception.InvalidInputException;
import player.Player;
import util.ColorConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayGame {
    public static void main(String[] args) throws InterruptedException, InvalidInputException {
        List<Player> players = new ArrayList<>();
        players.add(new Player("P1", ColorConstants.ANSI_GREEN_BACKGROUND));
        players.add(new Player("S2", ColorConstants.ANSI_YELLOW_BACKGROUND));
        players.add(new Player("I3", ColorConstants.ANSI_RED_BACKGROUND));

        Board gameBoard = new Board(players);

        //Snakes map contains key as snake entry point while value represent tail of snake
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(14, 7);
        gameBoard.setSnakes(snakes);

        //Ladders map contains key as ladder entry point while value represent top of ladder
        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(2, 100);
        gameBoard.setLadders(ladders);

        System.out.println(gameBoard.getBoard());

        boolean done = false;
        while (!done) {
            done = gameBoard.movePlayer(players.get(0));
            Thread.sleep(1000);
            System.out.println(gameBoard.getBoard());
        }
    }
}
