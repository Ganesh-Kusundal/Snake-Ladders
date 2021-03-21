package player;

import dice.Dice;
import util.ColorConstants;

public class Player {

    private String name;
    private String playerColor;
    private Dice dice;

    public Player(String name, String playerColor) {
        this.name = name;
        this.playerColor = playerColor;
        this.dice = new Dice();
    }

    public String getPlayerColor() {
        return playerColor;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public String getName() {
        return name;
    }

    public Integer takeTurn() {
        Integer roll = dice.roll();
        System.out.println(name + " rolled dice....." + ColorConstants.ANSI_RED_BACKGROUND + " " + roll + " " + ColorConstants.ANSI_RESET + "\n");
        return roll;
    }
}
