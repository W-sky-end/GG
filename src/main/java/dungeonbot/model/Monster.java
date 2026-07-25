package dungeonbot.model;

import java.util.ArrayList;
import java.util.List;

public class Monster extends Combatant {
    private int damage;
    private int maxHP;
    private int armorClass;
    private int dropXP;   //todo
    private int dropGold; //todo
    private List<String> drop; // todo переделать как появится список дропа

    public Monster(String name, int damage, int maxHP, int armorClass, int dropXP, int dropGold) {
        super(name);
        this.damage = damage;
        this.currentHP = maxHP;
        this.armorClass = armorClass;
        this.dropXP = dropXP;
        this.dropGold = dropGold;
        this.drop = new ArrayList<String>();
        this.maxHP = maxHP;
    }

    public int getDamage() {
        return damage;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getDropXP() {
        return dropXP;
    }

    public int getDropGold() {
        return dropGold;
    }

    public List<String> getDrop() {
        return drop;
    }
    public int getMaxHP() {
        return maxHP;
    }
}
