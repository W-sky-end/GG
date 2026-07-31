package dungeonbot.system;

import dungeonbot.model.Monster;
import dungeonbot.model.MonsterRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class EncounterService {
    private final Random rand = new Random();
    private final MonsterRepository monsterRepo;

    public EncounterService(MonsterRepository monsterRepo) {
        this.monsterRepo = monsterRepo;
    }

    public MonsterRepository getMonsterRepo() {
        return monsterRepo;
    }

    public Optional<Monster> resolveEncounter(int encounterChance, List<String> possibleMonsters) {
    int roll = rand.nextInt(100) + 1;

    if (roll > encounterChance || possibleMonsters.isEmpty()) {
        return Optional.empty();
    }
    String chooseName = possibleMonsters.get(rand.nextInt(possibleMonsters.size()));
    return Optional.ofNullable(monsterRepo.getByName(chooseName));
    }
}
