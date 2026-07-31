package dungeonbot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Monster extends Combatant {
    private int damage;
    private int maxHP;
    private int armorClass;
    private LootTable lootTable;

    @JsonCreator
    public Monster(@JsonProperty("name") String name,
                   @JsonProperty("damage") int damage,
                   @JsonProperty("maxHP") int maxHP,
                   @JsonProperty("armorClass") int armorClass,
                   @JsonProperty("lootTable") LootTable lootTable) {
        super(name);
        this.damage = damage;
        this.currentHP = maxHP;
        this.armorClass = armorClass;
        this.lootTable = lootTable;
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

    public int getMaxHP() {
        return maxHP;
    }
    public LootTable getLootTable() {
        return lootTable;
    }
}
