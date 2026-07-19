package dungeonbot.model;

import java.util.ArrayList;
import java.util.List;

public class Monster {
    private String name;
    private int damage;
    private int health;
    private int armorClass;
    private int dropXP;   //todo
    private int dropGold; //todo
    private List<String> drop; // todo переделать как появится список дропа

    public Monster(String name, int damage, int health, int armorClass, int dropXP, int dropGold) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.armorClass = armorClass;
        this.dropXP = dropXP;
        this.dropGold = dropGold;
        this.drop = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
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
}
