package dungeonbot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LootTable {
    private int expReward;
    private int minGold;
    private int maxGold;
    private List<LootEntry> possibleItems;

    @JsonCreator
    public LootTable(@JsonProperty("expReward") int expReward,
                     @JsonProperty("minGold") int minGold,
                     @JsonProperty("maxGold") int maxGold,
                     @JsonProperty("possibleItems") List<LootEntry> possibleItems) {
        this.expReward = expReward;
        this.minGold = minGold;
        this.maxGold = maxGold;
        this.possibleItems = possibleItems;
    }

    public int getExpReward() {
        return expReward;
    }

    public int getMinGold() {
        return minGold;
    }

    public int getMaxGold() {
        return maxGold;
    }

    public List<LootEntry> getPossibleItems() {
        return possibleItems;
    }
}