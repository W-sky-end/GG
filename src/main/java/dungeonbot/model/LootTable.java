package dungeonbot.model;

import java.util.ArrayList;
import java.util.List;

public class LootTable {
    private int expReward;
    private int minGold;
    private int maxGold;
    private List<LootEntry> possibleItems;

    public LootTable(int expReward, int minGold, int maxGold) {
        this.expReward = expReward;
        this.minGold = minGold;
        this.maxGold = maxGold;
        this.possibleItems = new ArrayList<LootEntry>();
    }
    public int getExpReward() {
        return expReward;
    }
    public int getMinGold() {
    return minGold; }
    public int getMaxGold() {
        return maxGold;
    }
    public List<LootEntry> getPossibleItems() {
        return possibleItems;
    }

}
