package board;

import board.component.ILadders;
import board.component.ISnakes;
import board.component.Ladders;
import board.component.Snakes;
import player.Player;
import util.ColorConstants;

import java.util.List;

public class Board extends BaseBoard {

    private ISnakes snakes;
    private ILadders ladders;

    public Board(List<Player> players, ISnakes snakes, ILadders ladders) {
        super(players);
        this.snakes = snakes;
        this.ladders = ladders;
    }

    @Override
    public boolean movePlayer(Player player) {
        Integer currentPosition = playerPositions.get(player) + player.takeTurn();

        if (snakes.isSnake(currentPosition)) {
            System.out.println(ColorConstants.ANSI_RED_BACKGROUND + "Eaten By Snake [" + currentPosition + "] ->  \uD83D\uDC0D  ->[" + snakes.nextPosition(currentPosition) + "]" + ColorConstants.ANSI_RESET);
            currentPosition = snakes.nextPosition(currentPosition);

        }

        if (ladders.isLadder(currentPosition)) {
            System.out.println(ColorConstants.ANSI_RED_BACKGROUND + "Jumped By Ladder [" + currentPosition + "] -> \uD83E\uDE9C  ->[" + snakes.nextPosition(currentPosition) + "]" + ColorConstants.ANSI_RESET);
            currentPosition = ladders.nextPosition(currentPosition);
        }

        if (currentPosition <= FINAL_POSITION)
            playerPositions.put(player, currentPosition);

        if (FINAL_POSITION == currentPosition) {
            System.out.println("Player " + player.getPlayerColor() + player.getName() + ColorConstants.ANSI_RESET + " Is Winner...Hurray!!!\n");
            return true;
        }
        return false;
    }
}
