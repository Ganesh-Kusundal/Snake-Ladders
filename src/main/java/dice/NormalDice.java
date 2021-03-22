package dice;

import java.util.Random;

public class NormalDice implements Dice {
    @Override
    public Integer roll() {
        return new Random().nextInt(6) + 1;
    }
}
