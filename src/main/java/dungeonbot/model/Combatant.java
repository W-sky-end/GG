package dungeonbot.model;

public abstract class Combatant {

    protected String name;
    protected int currentHP;

    protected Combatant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void takeDamage(int amount) {
        currentHP -= amount;
        if (currentHP < 0) {
            currentHP = 0;
        }
    }

    public boolean isAlive() {
        return currentHP > 0;
    }
}