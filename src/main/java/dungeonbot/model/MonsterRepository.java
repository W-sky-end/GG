package dungeonbot.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonsterRepository {
    private final Map<String, Monster> monsters = new HashMap<>();

    public MonsterRepository() {
        loadMonsters();
    }
    private void loadMonsters(){
        ObjectMapper mapper = new ObjectMapper();
        try(InputStream input = getClass().getClassLoader().getResourceAsStream("monsters.json")){
            if(input == null){
                throw new IllegalStateException("File monsters.json not found in resources!");
            }
            List<Monster> loadedMonsters = mapper.readValue(input, mapper.getTypeFactory().constructCollectionType(List.class, Monster.class));
            for(Monster monster : loadedMonsters){
                monsters.put(monster.getName(), monster);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error with loading", e);
        }
    }
    public Monster getByName(String id) {
        return monsters.get(id);
    }
}

