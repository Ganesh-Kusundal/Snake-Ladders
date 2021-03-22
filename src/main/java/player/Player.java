package player;

import dice.CrookedDice;
import dice.Dice;
import dice.DiceType;
import dice.NormalDice;
import util.ColorConstants;

public class Player {

    private String name;
    private String playerColor;
    private static Dice dice;

    public Player(String name, String playerColor) {
        this.name = name;
        this.playerColor = playerColor;
    }

    public String getPlayerColor() {
        return playerColor;
    }

    public static void setDice(Integer diceType) {
       switch (DiceType.NORMAL_DICE.getDiceTypeFromRank(diceType)) {
           case NORMAL_DICE -> dice = new NormalDice();
           case CROOCKED_DICE -> dice = new CrookedDice();
       }

    }

    public String getName() {
        return name;
    }

    public Integer takeTurn() {
        if (dice == null)
            dice = new NormalDice();

        Integer roll = dice.roll();

        System.out.println(name + " rolled dice....." + ColorConstants.ANSI_RED_BACKGROUND + " " + roll + " " + ColorConstants.ANSI_RESET + "\n");

        return roll;
    }
}
