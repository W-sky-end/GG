package dungeonbot.model;

import dungeonbot.system.CombatSystem;

import java.util.ArrayList;
import java.util.List;

public class Player extends Combatant {
    private int level = 1;
    private List<String> inventory; //todo
    private int currentGold = 0;
    private int currentXP = 0;
    private int maxHP;


    private int vitality;
    private int intelligence;
    private int strength;
    private int dexterity;

    public Player(String name) {
        super(name);
        this.level = 1;
        this.inventory = new ArrayList<>();
        this.currentGold = 0;
        this.currentXP = 0;
        this.vitality = 2;
        this.intelligence = 2;
        this.strength = 2;
        this.dexterity = 2;
        this.maxHP = vitality * 10;
        this.currentHP = maxHP;
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

    public int getCurrentHP() {return currentHP;}

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

    public int getMaxHP() {return maxHP;}

    // TODO: временный метод для ручного тестирования, удалить когда появится нормальная механика магазина
    public void debugAddGold(int amount) {
        this.currentGold += amount;
    }
    public int getMaxHp() {
        return vitality * 10;
    }
    // TODO: временная заглушка атаки для теста боя, убрать когда появится Weapon
    public int getAttackModifier() {
        return strength / 2;
    }
    // TODO: временная заглушка защиты для теста боя
    public int getDefenseModifier() {
        return vitality / 2;
    }
}
