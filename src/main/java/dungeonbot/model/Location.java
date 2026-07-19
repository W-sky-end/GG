package dungeonbot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Location {

    private final String name;
    private final String id;
    private final String description;
    private final List<String> nextLocationIds;
    private final List<String> possibleEffect;   // todo
    private final List<String> possibleMonsters; // todo

    @JsonCreator
    public Location(@JsonProperty("name") String name,
                    @JsonProperty("id") String id,
                    @JsonProperty("description") String description,
                    @JsonProperty("nextLocationIds") List<String> nextLocationIds,
                    @JsonProperty("possibleEffects") List<String> possibleEffect,
                    @JsonProperty("possibleMonsters") List<String> possibleMonsters) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.nextLocationIds = nextLocationIds;
        this.possibleEffect = possibleEffect;
        this.possibleMonsters = possibleMonsters;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getNextLocationIds() {
        return nextLocationIds;
    }

    public List<String> getPossibleEffect() {
        return possibleEffect;
    }

    public List<String> getPossibleMonsters() {
        return possibleMonsters;
    }
}
