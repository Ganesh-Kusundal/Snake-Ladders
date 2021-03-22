package game;

import board.BaseBoard;
import board.Board;
import board.component.*;
import board.display.IPrintBoard;
import board.display.PrintBoardToConsole;
import exception.InvalidInputException;
import player.Player;
import util.ColorConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) throws InterruptedException, InvalidInputException {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Please enter number between 1 to 4 for number of players-");
        List<Player> players = new ArrayList<>();

        Integer numberOfPlayer = scanner.nextInt();
        for (int i = 1; i <= numberOfPlayer; i++) {
            System.out.println("Please enter player-" + i + " name-");
            String playersName = scanner.next();

            System.out.println("Please select player-" + i + " Color(1.Green/2.Yellow/3.Red/4.Blue)-");
            players.add(new Player(playersName, getSelectColor(scanner.nextInt())));

        }

        System.out.println("Please enter 1. Normal Dice or 2. Crooked Dice -");
        Player.setDice(scanner.nextInt());


        ISnake snake = new Snake(10, 2);
        ISnake greenSnake = new GreenSnake(50, 25);
        List<ISnake> snakes = Arrays.asList(snake, greenSnake);

        ILadder ladder = new Ladder(2, 25);
        List<ILadder> ladders = Arrays.asList(ladder);

        BaseBoard gameBaseBoard = new Board(players, snakes, ladders);

        IPrintBoard print = new PrintBoardToConsole(gameBaseBoard);
        print.printBoard();


        boolean done = false;
        while (!done) {
            done = players.stream().anyMatch(gameBaseBoard::movePlayer);
            Thread.sleep(1000);
            print.printBoard();
        }
    }

    private static String getSelectColor(Integer playerColor) throws InvalidInputException {
        switch (playerColor) {
            case 1:
                return ColorConstants.ANSI_GREEN_BACKGROUND;
            case 2:
                return ColorConstants.ANSI_YELLOW_BACKGROUND;
            case 3:
                return ColorConstants.ANSI_RED_BACKGROUND;
            case 4:
                return ColorConstants.ANSI_BLUE_BACKGROUND;
            default:
                throw new InvalidInputException("Selected color is invalid.");
        }
    }
}
