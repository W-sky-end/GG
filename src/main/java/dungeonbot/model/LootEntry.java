package dungeonbot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LootEntry {
    private String itemId;
    private double dropChance;

    @JsonCreator
    public LootEntry(@JsonProperty("itemId")String itemId,
                     @JsonProperty("dropChance")double dropChance) {
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
