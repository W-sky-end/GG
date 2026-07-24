package dungeonbot.system;

import java.util.Random;

public class Dice {
    private final  Random rand = new Random();
    public int rollDice() {
        return rand.nextInt(20) + 1;
    }
}
