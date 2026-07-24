package dungeonbot.system;

public class CombatSystem {
    private final Dice dice;

    public CombatSystem(Dice dice) {
        this.dice = dice;
    }
    public boolean isHit ( int attackModifier, int defenceModifier ) {
        int roll = dice.rollDice();
        return roll + attackModifier - defenceModifier >= 0;
    }
    public int calculateDamage(int attackDamageModifier){
        int roll = dice.rollDice();
        return roll + attackDamageModifier;
    }
}
