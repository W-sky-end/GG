package dungeonbot.model;

public class LootEntry {
    private String itemId;
    private double dropChance;

    public LootEntry(String itemId, double dropChance) {
        this.itemId = itemId;
        this.dropChance = dropChance;
    }
    public String getItemId() {
        return itemId;
    }
    public double getDropChance() {
        return dropChance;
    }
}
