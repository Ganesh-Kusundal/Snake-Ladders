package board;

import board.component.ILadder;
import board.component.ISnake;
import player.Player;
import util.ColorConstants;

import java.util.List;

public class Board extends BaseBoard {

    private List<ISnake> snakes;
    private List<ILadder> ladders;

    public Board(List<Player> players, List<ISnake> snakes, List<ILadder> ladders) {
        super(players);
        this.snakes = snakes;
        this.ladders = ladders;
    }

    @Override
    public boolean movePlayer(Player player) {
        Integer currentPosition = playerPositions.get(player) + player.takeTurn();


        do {

            ISnake snake = isSneakAt(currentPosition);

            if (snake != null) {
                Integer nextPosition = snake.nextPosition(currentPosition);
                System.out.println(ColorConstants.ANSI_RED_BACKGROUND + "Eaten By Snake [" + currentPosition + "] ->  \uD83D\uDC0D  ->[" + nextPosition + "]" + ColorConstants.ANSI_RESET);
                currentPosition = nextPosition;

            }

            ILadder ladder = isLadderAt(currentPosition);
            if (ladder != null) {
                Integer nextPosition = ladder.nextPosition(currentPosition);
                System.out.println(ColorConstants.ANSI_RED_BACKGROUND + "Jumped By Ladder [" + currentPosition + "] -> \uD83E\uDE9C  ->[" + nextPosition + "]" + ColorConstants.ANSI_RESET);
                currentPosition = nextPosition;
            }

        } while (isSnakeORLadderAt(currentPosition));

        if (currentPosition <= FINAL_POSITION)
            playerPositions.put(player, currentPosition);

        if (FINAL_POSITION == currentPosition) {
            System.out.println("Player " + player.getPlayerColor() + player.getName() + ColorConstants.ANSI_RESET + " Is Winner...Hurray!!!\n");
            return true;
        }
        return false;
    }

    private boolean isSnakeORLadderAt(Integer currentPosition) {
        return null != isSneakAt(currentPosition) || null != isLadderAt(currentPosition);
    }

    private ISnake isSneakAt(Integer currentPosition) {
        for (ISnake snake : snakes) {
            if (snake.isSnake(currentPosition))
                return snake;
        }
        return null;
    }

    private ILadder isLadderAt(Integer currentPosition) {
        for (ILadder ladder : ladders) {
            if (ladder.isLadder(currentPosition))
                return ladder;
        }
        return null;
    }


}
