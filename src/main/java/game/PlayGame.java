package game;

import board.Board;
import player.Player;
import util.ColorConstants;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("P1", ColorConstants.ANSI_GREEN_BACKGROUND));
        players.add(new Player("P2", ColorConstants.ANSI_YELLOW_BACKGROUND));

        Board gameBoard = new Board(players);

        System.out.println(gameBoard.getBoard());

        boolean done = false;

        while (!done) {
            done = gameBoard.movePlayer(players.get(0)) || gameBoard.movePlayer(players.get(1));
            System.out.println(gameBoard.getBoard());
        }
    }
}
