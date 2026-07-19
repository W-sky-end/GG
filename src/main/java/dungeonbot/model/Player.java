package dungeonbot.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int level = 1;
    private List<String> inventory; //todo
    private int currentGold = 0;
    private int currentXP = 0;
    private int currentHP;

    private int vitality = 2;
    private int intelligence = 2;
    private int strength = 2;
    private int dexterity = 2;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.inventory = new ArrayList<>();
        this.currentGold = 0;
        this.currentXP = 0;
        this.vitality = 2;
        this.intelligence = 2;
        this.strength = 2;
        this.dexterity = 2;
        this.currentHP = vitality * 10;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentGold() {
        return currentGold;
    }

    public int getCurrentXP() {
        return currentXP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getVitality() {
        return vitality;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public List<String> getInventory() {
        return inventory;
    }
    // TODO: временный метод для ручного тестирования, удалить когда появится нормальная механика магазина
    public void debugAddGold(int amount) {
        this.currentGold += amount;
    }
    public int getMaxHp() {
        return vitality * 10;
    }
}
