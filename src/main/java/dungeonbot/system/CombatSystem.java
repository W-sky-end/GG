package dungeonbot.system;

public class CombatSystem {
    private final Dice dice;

    public CombatSystem(Dice dice) {
        this.dice = dice;
    }
    public boolean isHit ( int attackModifier, int enemyDefenceModifier ) {
        int roll = dice.rollDice();
        return roll + attackModifier - enemyDefenceModifier >= 0;
    }
    public int calculateDamage(int attackDamageModifier){
        int roll = dice.rollDice();
        return roll + attackDamageModifier;
    }
    public int performAttack(int attackModifier , int enemyDefence){
        if ( isHit(attackModifier,enemyDefence)){
            return calculateDamage(attackModifier);
        }
        return 0;
    }
}
