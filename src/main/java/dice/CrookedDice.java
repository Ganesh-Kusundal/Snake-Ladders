package dice;

import java.util.Random;

public class CrookedDice implements Dice {
    @Override
    public Integer roll() {
        Integer outCome = 0;

        while ((outCome = new Random().nextInt(6) + 1) % 2 != 0) ;

        return outCome;
    }
}
